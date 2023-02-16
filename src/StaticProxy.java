/**
 * @Author: liuhh
 * @Date: 2022/10/10
 */
public class StaticProxy {
    public static void main(String[] args) {
        new WeddingCompany(new Person()).marry();
    }
}
interface Marry{
    void marry();
}

//真实对象
class Person implements Marry{

    @Override
    public void marry() {
        System.out.println("我要结婚啦！");
    }
}

//代理对象
class WeddingCompany implements Marry{

    private Marry marry;

    public WeddingCompany(Marry marry){
        this.marry = marry;
    }


    @Override
    public void marry() {
        before();
        this.marry.marry();
        after();
    }

    private void after() {
        System.out.println("--场景拆除---");
    }

    private void before() {
        System.out.println("--场景布置---");
    }
}