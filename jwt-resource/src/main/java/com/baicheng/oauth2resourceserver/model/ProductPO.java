package com.baicheng.oauth2resourceserver.model;

import java.io.Serializable;

public class ProductPO implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.id
     *
     * @mbg.generated Wed Feb 27 21:04:45 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.version
     *
     * @mbg.generated Wed Feb 27 21:04:45 CST 2019
     */
    private Integer version;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.is_deleted
     *
     * @mbg.generated Wed Feb 27 21:04:45 CST 2019
     */
    private Boolean isDeleted;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.name
     *
     * @mbg.generated Wed Feb 27 21:04:45 CST 2019
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_product
     *
     * @mbg.generated Wed Feb 27 21:04:45 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.id
     *
     * @return the value of t_product.id
     *
     * @mbg.generated Wed Feb 27 21:04:45 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_product
     *
     * @mbg.generated Wed Feb 27 21:04:45 CST 2019
     */
    public ProductPO withId(Integer id) {
        this.setId(id);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.id
     *
     * @param id the value for t_product.id
     *
     * @mbg.generated Wed Feb 27 21:04:45 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.version
     *
     * @return the value of t_product.version
     *
     * @mbg.generated Wed Feb 27 21:04:45 CST 2019
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_product
     *
     * @mbg.generated Wed Feb 27 21:04:45 CST 2019
     */
    public ProductPO withVersion(Integer version) {
        this.setVersion(version);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.version
     *
     * @param version the value for t_product.version
     *
     * @mbg.generated Wed Feb 27 21:04:45 CST 2019
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.is_deleted
     *
     * @return the value of t_product.is_deleted
     *
     * @mbg.generated Wed Feb 27 21:04:45 CST 2019
     */
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_product
     *
     * @mbg.generated Wed Feb 27 21:04:45 CST 2019
     */
    public ProductPO withIsDeleted(Boolean isDeleted) {
        this.setIsDeleted(isDeleted);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.is_deleted
     *
     * @param isDeleted the value for t_product.is_deleted
     *
     * @mbg.generated Wed Feb 27 21:04:45 CST 2019
     */
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.name
     *
     * @return the value of t_product.name
     *
     * @mbg.generated Wed Feb 27 21:04:45 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_product
     *
     * @mbg.generated Wed Feb 27 21:04:45 CST 2019
     */
    public ProductPO withName(String name) {
        this.setName(name);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.name
     *
     * @param name the value for t_product.name
     *
     * @mbg.generated Wed Feb 27 21:04:45 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_product
     *
     * @mbg.generated Wed Feb 27 21:04:45 CST 2019
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", version=").append(version);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", name=").append(name);
        sb.append("]");
        return sb.toString();
    }
}