package everyday;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/5 15:52
 */
public class 分发糖果 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int times = 0;
        while (candies > 0) {
            // for (int i = 0; i < res.length; i++){
            //     int candie = times * num_people + (i + 1);
            //     // 先看按照计算分得的糖果是不是大于剩余糖果数
            //     // 如果不是的话，就直接将剩余糖果数分给人
            //     if (candies < candie) {
            //         res[i] += candies;
            //         candies -= candie;
            //         break;
            //     } else {
            //         res[i] += candie;
            //         candies -= candie;
            //     }
            // }
            // times++;

            res[times % num_people] += Math.min(times + 1, candies);
            times += 1;
            candies -= times;
        }
        return res;
    }
}
