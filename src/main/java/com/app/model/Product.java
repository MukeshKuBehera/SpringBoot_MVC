package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT_TAB")
public class Product {
	
	
	

		@Id
		@Column(name="id")
		@GeneratedValue
		private Integer id;
		@Column(name="code")
		private String code;
		@Column(name="name")
		private String name;
		@Column(name="cost")
		private Double cost;
		@Column(name="gst")
		private String gst;
		@Column(name="note")
		private String note;
		public Product(Integer id, String code, String name, Double cost, String gst, String note) {
			super();
			this.id = id;
			this.code = code;
			this.name = name;
			this.cost = cost;
			this.gst = gst;
			this.note = note;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Double getCost() {
			return cost;
		}
		public void setCost(Double cost) {
			this.cost = cost;
		}
		public String getGst() {
			return gst;
		}
		public void setGst(String gst) {
			this.gst = gst;
		}
		public String getNote() {
			return note;
		}
		public void setNote(String note) {
			this.note = note;
		}
		public Product() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Product [id=" + id + ", code=" + code + ", name=" + name + ", cost=" + cost + ", gst=" + gst + ", note="
					+ note + "]";
		}
		
		
	

}
