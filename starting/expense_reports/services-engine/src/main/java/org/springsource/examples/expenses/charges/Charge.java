package org.springsource.examples.expenses.charges;

import org.springsource.examples.expenses.reports.LineItem;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * A {@link Charge} is a non reconciled charge that has come from some sort of credit card source. (The placeholder entity
 * to represent that source is {@link org.springsource.examples.expenses.users.CreditCard}.
 *
 * @author Josh Long
 */
@Entity
public class Charge {
	private long chargeId;
	private ChargeBatch chargeBatch;
	private double chargeAmount;
	private String description;
	private Set<LineItem> lineItems = new HashSet<LineItem>(0);


	@Id
	@javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	@Column(name = "charge_id", unique = true, nullable = false)
	public long getChargeId() {
		return this.chargeId;
	}

	public void setChargeId(long chargeId) {
		this.chargeId = chargeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "charge_batch_id", nullable = false)
	public ChargeBatch getChargeBatch() {
		return this.chargeBatch;
	}

	public void setChargeBatch(ChargeBatch chargeBatch) {
		this.chargeBatch = chargeBatch;
	}

	@Column(name = "charge_amount", nullable = false, precision = 17, scale = 17)
	public double getChargeAmount() {
		return this.chargeAmount;
	}

	public void setChargeAmount(double chargeAmount) {
		this.chargeAmount = chargeAmount;
	}

	@Column(name = "description", nullable = false, length = 1000)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "charge")
	public Set<LineItem> getLineItems() {
		return this.lineItems;
	}

	public void setLineItems(Set<LineItem> lineItems) {
		this.lineItems = lineItems;
	}
}