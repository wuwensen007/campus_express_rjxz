package com.rjxz.xykd.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.rjxz.xykd.util.LongJsonDeserializer;
import com.rjxz.xykd.util.LongJsonSerializer;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import java.util.HashMap;

public class Order {

    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long id;

    private String itemtype;

    private String notes;

    private String phone;

    private String receiveraddress;

    public String getReceiveraddress() {
        return receiveraddress;
    }

    public void setReceiveraddress(String receiveraddress) {
        this.receiveraddress = receiveraddress;
    }

    private Long userid;

    private Long courierid;

//    private Account staffaccount;
//
//    private Account useraccount;

//    public Account getStaffaccount() {
//        return staffaccount;
//    }

//    public void setStaffaccount(Account staffaccount) {
//        this.staffaccount = staffaccount;
//    }
//
//    public Account getUseraccount() {
//        return useraccount;
//    }
//
//    public void setUseraccount(Account useraccount) {
//        this.useraccount = useraccount;
//    }

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime time;

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    private OrderType ordertype;

    private HashMap<String, Object> spec = new HashMap<String, Object>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemtype() {
        return itemtype;
    }

    public void setItemtype(String itemtype) {
        this.itemtype = itemtype;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getCourierid() {
        return courierid;
    }

    public void setCourierid(Long courierid) {
        this.courierid = courierid;
    }

    public OrderType getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(OrderType ordertype) {
        this.ordertype = ordertype;
    }

    public HashMap<String, Object> getSpec() {
        return spec;
    }

    public void setSpec(HashMap<String, Object> spec) {
        this.spec = spec;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", itemtype='" + itemtype + '\'' +
                ", notes='" + notes + '\'' +
                ", phone='" + phone + '\'' +
                ", receiveraddress='" + receiveraddress + '\'' +
                ", userid=" + userid +
                ", courierid=" + courierid +
//                ", staffaccount=" + staffaccount +
//                ", useraccount=" + useraccount +
                ", time=" + time +
                ", ordertype=" + ordertype +
                ", spec=" + spec +
                '}';
    }
}
