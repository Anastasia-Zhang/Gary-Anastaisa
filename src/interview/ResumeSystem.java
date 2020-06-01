package interview;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/4/7 19:12
 */
public class ResumeSystem {
    // 使用linkedList 模拟简历池
    private final LinkedList<Resume> resumesPool = new LinkedList<>();
    // 简历池容量
    private final int MAX = 100;
    // 系统内简历的数量
    private int count = 0;
    // 记录
    private ConcurrentHashMap<String, String> resumesResult = new ConcurrentHashMap<>();

    // HR获得简历，将简历放入简历池
    public synchronized void putResume(Resume resume) throws InterruptedException {
        while (MAX == resumesPool.size()) {
            wait();
        }
        count++;
        resumesPool.addLast(resume);
        System.out.println("已经放入简历： " + resume.getResumeId());
        notifyAll();
    }

    // 面试官从简历池中处理简历
    public synchronized Resume getResume() throws InterruptedException {
        while (0 == resumesPool.size()) {
            wait();
        }
        count--;
        Resume resume = resumesPool.removeLast();
        System.out.println(Thread.currentThread().getName() + " 获得简历： " + resume.getResumeId());
        return resume;
    }

    // HR 获得简历 面试官面试
    public void interview() {

        new Thread(()->{
            while (true) {
                Resume resume = new Resume(String.valueOf((int) (Math.random() * 100)));
                int time = (int) (Math.random() * 10 + 1);
                try {
                    Thread.sleep(time * 1000);
                    putResume(resume);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"HR").start();

        new Thread(()->{
            while (true) {
                try {
                    Thread.sleep(3000);
                    Resume resume = getResume();
                    String result = new Random().nextInt(2) == 0 ? "noPass" : "pass";
                    resumesResult.put(resume.getResumeId(), result);
                    System.out.println("简历 " + resume.getResumeId() + "结果为： " + resumesResult.get(resume.getResumeId()));

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"interviewerA").start();

        new Thread(()->{
            while (true) {
                try {
                    Thread.sleep(5000);
                    Resume resume = getResume();
                    String result = new Random().nextInt(2) == 0 ? "noPass" : "pass";
                    resumesResult.put(resume.getResumeId(), result);
                    System.out.println("简历 " + resume.getResumeId() + "结果为： " + resumesResult.get(resume.getResumeId()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"interviewerB").start();

    }

    public static void main(String[] args) {
        ResumeSystem resumeSystem = new ResumeSystem();
        resumeSystem.interview();
    }
}

class Resume {
    // 简历id
    private String resumeId;
    // 应聘者姓名
    private String name;
    // 简历内容
    private String content;

    public Resume(String resumeId) {
        // 以简历ID来唯一标识每一封简历
        this.resumeId = resumeId;
    }

    public String getResumeId() {
        return resumeId;
    }

    public void setResumeId(String resumeId) {
        this.resumeId = resumeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

