package com.test.controllers;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "stock")
public class Stock {

		private Integer stockId;
		private String stockCode;
		private String stockName;

		public Stock() {
		}

		public Stock(String stockCode, String stockName) {
			this.stockCode = stockCode;
			this.stockName = stockName;
		}

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "STOCK_ID", unique = true, nullable = false)
		public Integer getStockId() {
			return this.stockId;
		}

		public void setStockId(Integer stockId) {
			this.stockId = stockId;
		}

		@Column(name = "STOCK_CODE", unique = true, nullable = false, length = 10)
		public String getStockCode() {
			return this.stockCode;
		}

		public void setStockCode(String stockCode) {
			this.stockCode = stockCode;
		}

		@Column(name = "STOCK_NAME", unique = true, nullable = false, length = 20)
		public String getStockName() {
			return this.stockName;
		}

		public void setStockName(String stockName) {
			this.stockName = stockName;
		}
}
