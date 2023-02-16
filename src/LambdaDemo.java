/**
 * @Author: liuhh
 * @Date: 2022/10/11
 */


public class LambdaDemo {

    //静态内部类
    static class Love2 implements ILove{
        @Override
        public void love() {
            System.out.println("I love you -- liuhh");
        }
    }



    public static void main(String[] args) {
        ILove love = new Love1();
        love.love();

        love = new Love2();
        love.love();

        //局部内部类
        class Love3 implements ILove{

            @Override
            public void love() {
                System.out.println("I love you -- liupp");
            }
        }

        love = new Love3();
        love.love();

        //匿名内部类,没有类的名称，必须借助接口或者父类
        love = new ILove() {
            @Override
            public void love() {
                System.out.println("I love you -- liuxx");
            }
        };
        love.love();


        //lambda表达式
        love = ()->{
            System.out.println("i  love you -- lambda");
        };
        love.love();

        love = ()-> System.out.println("I love you -- lambda2");
        love.love();

    }

}


//函数式接口，接口中只含有一个抽象方法
interface ILove{
    void love();
}

//实现类
class Love1 implements ILove{
    @Override
    public void love() {
        System.out.println("I Love you -- liucc");
    }
}