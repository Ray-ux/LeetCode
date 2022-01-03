package oneday;

/**
 * 一周中的第几天
 * @author 张烈文
 * @date 2022/1/3 22:26
 */
public class DayOfWeek {
    String[] res = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    int[] nums = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public String dayOfTheWeek(int day, int month, int year) {
        int ans = 4;
        for(int i=1971;i<year;i++){
            boolean isLeap = (i % 4 == 0 && i % 100 != 0) || i % 400 == 0;
            ans += isLeap ? 366 : 365;
        }
        for(int i=1;i<month-1;i++){
            ans+=nums[i-1];
            if(i==2&&((year % 4 == 0 && year % 100 != 0) || year % 400==0)) ans++;
        }
        ans += day;
        return res[ans % 7];
    }
}
