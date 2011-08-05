package org.springsource.examples.expenses.model;
// Generated Aug 5, 2011 1:50:40 AM by Hibernate Tools 3.2.0.CR1


import javax.persistence.*;

/**
 * Attachment generated by hbm2java
 */
@Entity
@Table(name = "attachment"
		      , schema = "public"
)
public class Attachment implements java.io.Serializable {


	private long attachmentId;
	private ManagedFile managedFile;
	private ExpenseReportLine expenseReportLine;

	public Attachment() {
	}

	public Attachment(long attachmentId, ManagedFile managedFile, ExpenseReportLine expenseReportLine) {
		this.attachmentId = attachmentId;
		this.managedFile = managedFile;
		this.expenseReportLine = expenseReportLine;
	}

	@Id
	@Column(name = "attachment_id", unique = true, nullable = false)
	public long getAttachmentId() {
		return this.attachmentId;
	}

	public void setAttachmentId(long attachmentId) {
		this.attachmentId = attachmentId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "managed_file_id", nullable = false)
	public ManagedFile getManagedFile() {
		return this.managedFile;
	}

	public void setManagedFile(ManagedFile managedFile) {
		this.managedFile = managedFile;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "expense_report_line_id", nullable = false)
	public ExpenseReportLine getExpenseReportLine() {
		return this.expenseReportLine;
	}

	public void setExpenseReportLine(ExpenseReportLine expenseReportLine) {
		this.expenseReportLine = expenseReportLine;
	}


}

