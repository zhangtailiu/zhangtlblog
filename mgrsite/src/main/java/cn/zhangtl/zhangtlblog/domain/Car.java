package cn.zhangtl.zhangtlblog.domain;

/**
 * 
 *
 * @author null
 * @date   2019-09-06
 */
public class Car {
    /**
     * 主键
     */
    private Long id;

    /**
     * 信息
     */
    private String info;

    /**
     * 数量
     */
    private Integer num;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 产品id
     */
    private Integer productId;

    public Car(Long id, String info, Integer num, Long userId, Integer productId) {
        this.id = id;
        this.info = info;
        this.num = num;
        this.userId = userId;
        this.productId = productId;
    }

    public Car() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}