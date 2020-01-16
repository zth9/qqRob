package cn.javak.qqrob.pojo;


public class Sign {
    private int id;
    private String userAcc;
    private String groupAcc;
    private int signCount;
    private String leastSignTime;

    public Sign(){}

    public Sign(String userAcc, String groupAcc) {
        this.userAcc = userAcc;
        this.groupAcc = groupAcc;
    }

    @Override
    public String toString() {
        return "Sign{" +
                "id=" + id +
                ", userAcc='" + userAcc + '\'' +
                ", groupAcc='" + groupAcc + '\'' +
                ", signCount=" + signCount +
                ", leastSignTime='" + leastSignTime + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserAcc() {
        return userAcc;
    }

    public void setUserAcc(String userAcc) {
        this.userAcc = userAcc;
    }

    public String getGroupAcc() {
        return groupAcc;
    }

    public void setGroupAcc(String groupAcc) {
        this.groupAcc = groupAcc;
    }

    public int getSignCount() {
        return signCount;
    }

    public void setSignCount(int signCount) {
        this.signCount = signCount;
    }

    public String getLeastSignTime() {
        return leastSignTime;
    }

    public void setLeastSignTime(String leastSignTime) {
        this.leastSignTime = leastSignTime;
    }
}
