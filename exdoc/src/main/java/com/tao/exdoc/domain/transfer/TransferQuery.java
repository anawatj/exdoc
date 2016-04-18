package com.tao.exdoc.domain.transfer;

import java.util.Date;

import com.tao.exdoc.domain.AbstractQuery;

public class TransferQuery extends AbstractQuery
{
		public TransferQuery()
		{
			
		}
		private String transferCode;
		private String transferDesc;
		private Date transferDateStart;
		private Date transferDateEnd;
		private String transferBy;
		private Date reviewDateStart;
		private Date reviewDateEnd;
		private String reviewBy;
		private Date approveDateStart;
		private Date approveDateEnd;
		private String approveBy;
		private Integer objective;
		private Integer branch;
		private Integer department;
		private Integer position;
		public String getTransferCode() {
			return transferCode;
		}
		public void setTransferCode(String transferCode) {
			this.transferCode = transferCode;
		}
		public String getTransferDesc() {
			return transferDesc;
		}
		public void setTransferDesc(String transferDesc) {
			this.transferDesc = transferDesc;
		}
		public Date getTransferDateStart() {
			return transferDateStart;
		}
		public void setTransferDateStart(Date transferDateStart) {
			this.transferDateStart = transferDateStart;
		}
		public Date getTransferDateEnd() {
			return transferDateEnd;
		}
		public void setTransferDateEnd(Date transferDateEnd) {
			this.transferDateEnd = transferDateEnd;
		}
		public String getTransferBy() {
			return transferBy;
		}
		public void setTransferBy(String transferBy) {
			this.transferBy = transferBy;
		}
		public Date getReviewDateStart() {
			return reviewDateStart;
		}
		public void setReviewDateStart(Date reviewDateStart) {
			this.reviewDateStart = reviewDateStart;
		}
		public Date getReviewDateEnd() {
			return reviewDateEnd;
		}
		public void setReviewDateEnd(Date reviewDateEnd) {
			this.reviewDateEnd = reviewDateEnd;
		}
		public String getReviewBy() {
			return reviewBy;
		}
		public void setReviewBy(String reviewBy) {
			this.reviewBy = reviewBy;
		}
		public Date getApproveDateStart() {
			return approveDateStart;
		}
		public void setApproveDateStart(Date approveDateStart) {
			this.approveDateStart = approveDateStart;
		}
		public Date getApproveDateEnd() {
			return approveDateEnd;
		}
		public void setApproveDateEnd(Date approveDateEnd) {
			this.approveDateEnd = approveDateEnd;
		}
		public String getApproveBy() {
			return approveBy;
		}
		public void setApproveBy(String approveBy) {
			this.approveBy = approveBy;
		}
		public Integer getObjective() {
			return objective;
		}
		public void setObjective(Integer objective) {
			this.objective = objective;
		}
		public Integer getBranch() {
			return branch;
		}
		public void setBranch(Integer branch) {
			this.branch = branch;
		}
		public Integer getDepartment() {
			return department;
		}
		public void setDepartment(Integer department) {
			this.department = department;
		}
		public Integer getPosition() {
			return position;
		}
		public void setPosition(Integer position) {
			this.position = position;
		}
}
