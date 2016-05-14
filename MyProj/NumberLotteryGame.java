package MyProj;

import java.util.Arrays;

/**
 * NumberLotteryGame
 * 一个简单的数字彩票游戏类
 * @author LuisZhang
 * 参考了core java 8th中的例3-7的设计思想
 */
public class NumberLotteryGame {
    private int gamesNumber;    // 生成游戏的数量，为以后多线程扩展做考虑
    private int numbersLength;  // 数字序列的总长度
    private int winningNumbersLength;  // 中奖的数字序列的长度

    /**
     * Constructor with three parameters
     * 初始化3个参数的构造方法
     * @param gamesNumber
     * @param numbersLength
     * @param winningNumbersLength
     */
    public NumberLotteryGame(int gamesNumber, int numbersLength, int winningNumbersLength) {
        this.gamesNumber = gamesNumber;
        this.numbersLength = numbersLength;
        this.winningNumbersLength = winningNumbersLength;
    }

    /**
     * Generate a number Array
     * 生成一个产生中奖序列所需的数字序列
     * @param length 数字序列的长度
     * @return numbers 产生的数字序列
     */
    public static int[] generateNumberArray(int length) {
        int[] numbers = new int[length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        return numbers;
    }

    /**
     * Generate a winning number array
     * 根据生成的数字序列，产生不重复的中奖数字序列
     * @param length 中奖数字序列的长度
     * @return result 中奖数字数组
     */
    public int[] generateWinningNumberArray(int length) {
        int[] numbers = NumberLotteryGame.generateNumberArray(numbersLength);

        int[] result = new int[length];

        int n = numbersLength;

        // 该for循环为产生不重复的中奖序列的核心代码
        for(int i = 0; i < result.length; i++) {
            int r = (int) (Math.random() * n);  // 随机产生一个从0——(n-1)的数字,Math.random()
            // 随机产生一个[0, 1)范围的double型数值,
            result[i] = numbers[r];             // 将该随机数字作为数组的下标，
            // 将该下标对应的值赋给result[i]
            numbers[r] = numbers[n - 1];        // 将numbers数组的numbers[n-1]的值，赋给刚已赋
            // 值过的numbers[r]。
            n--;   // 将n-1,从而下一次循环产生的随机的原数组下标的范围从0——（n-1）-1,
            // 保证了上一步中，已经赋值给数组中其他数的numbers[n-1]，不会在下次循环中给取
            // 得，从而保证了产生的中奖数组result为不重复的。
        }

        return result;
    }

    /**
     * Show winning NumberArray
     * 显示中将数组
     */
    public void showWinningNumberArray() {
        int[] winningNumbers = this.generateWinningNumberArray(winningNumbersLength);
        Arrays.sort(winningNumbers);

        for(int r : winningNumbers) {
            System.out.print(r + " ");
        }

        System.out.println();
    }

    /**
     * @return the gamesNumber
     */
    public int getGamesNumber() {
        return gamesNumber;
    }

    /**
     * @param gamesNumber the gamesNumber to set
     */
    public void setGamesNumber(int gamesNumber) {
        this.gamesNumber = gamesNumber;
    }

    /**
     * @return the numbersLength
     */
    public int getNumbersLength() {
        return numbersLength;
    }

    /**
     * @param numbersLength the numbersLength to set
     */
    public void setNumbersLength(int numbersLength) {
        this.numbersLength = numbersLength;
    }

    /**
     * @return the winningNumbersLength
     */
    public int getWinningNumbersLength() {
        return winningNumbersLength;
    }

    /**
     * @param winningNumbersLength the winningNumbersLength to set
     */
    public void setWinningNumbersLength(int winningNumbersLength) {
        this.winningNumbersLength = winningNumbersLength;
    }

    /**
     * Main method
     * 用于测试该类的main方法
     * @param args
     */
    public static void main(String[] args) {
        int i = 20;    // int i = Integer.parseInt(args[0]);
        for(int j = 0; j < i; j++) {
            NumberLotteryGame game1 = new NumberLotteryGame(1, 15, 7);
            game1.showWinningNumberArray();
        }
    }
}
