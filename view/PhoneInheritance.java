package view;

public class PhoneInheritance {
    public static void main(String[] args) {
        System.out.println("------------------ 집전화 ------------------");
        Phone p = new Phone();
        p.setCompany("금성");
        p.setCall("제임스");
        System.out.println(p.toString());
        System.out.println("------------------ 휴대전화 ------------------");
        CellPhone cp = new CellPhone();
        cp.setCompany("노키아");
        cp.setCall("에릭");
        cp.setPortable(true);
        System.out.println(cp.toString());
        System.out.println("------------------ 아이폰 ------------------");
        IPhone ip = new IPhone();
        ip.setCompany("애플");
        ip.setPortable(true);
        ip.setCall("톰");
        ip.setData("전송하다");
        System.out.println(ip.toString());
        System.out.println("------------------ 갤럭시 ------------------");
        AndroidPhone ap = new AndroidPhone();
        ap.setCompany("삼성");
        ap.setPortable(true);
        ap.setCall("제인");
        ap.setData("전송하다");
        ap.setSize("10인치");
        System.out.println(ap.toString());


    }
}

class AndroidPhone extends IPhone {
    private String size;
    public static String BRAND = "Galaxy Note";

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "안드로이드폰{" +
                "회사='" + company + '\'' +
                ", 브랜드='" + BRAND + '\'' +
                ", 크기='" + size + '\'' +
                ", 휴대유무='" + move + '\'' +
                ", 수신자='" + call + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}

class IPhone extends CellPhone {
    protected String data;

    public static String BRAND = "iPhone";

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "아이폰{" +
                "회사='" + company + '\'' +
                ", 브랜드='" + BRAND + '\'' +
                ", 휴대유무='" + move + '\'' +
                ", 수신자='" + call + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}

class CellPhone extends Phone {
    protected boolean portable;
    protected String move;

    public boolean isPortable() {
        return portable;
    }

    public void setPortable(boolean portable) {
        this.setMove(portable ? "휴대 가능" : "휴대 불가");
        this.portable = portable;
    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }

    @Override
    public String toString() {
        return "휴대폰{" +
                "이동성=" + portable +
                ", 이동유무='" + move + '\'' +
                ", 회사='" + company + '\'' +
                ", 수신자='" + call + '\'' +
                '}';
    }
}

class Phone {
    protected String company, call;
    static final double TAX_RATE = 0.095;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company + "에서 제작하다";
    }

    public String getCall() {
        return call;
    }

    public void setCall(String call) {
        this.call = call + "에게 전화를 걸다";
    }

    @Override
    public String toString() {
        return "집전화{" +
                "제조사='" + company + '\'' +
                ", 수신자='" + call + '\'' +
                '}';
    }
}
