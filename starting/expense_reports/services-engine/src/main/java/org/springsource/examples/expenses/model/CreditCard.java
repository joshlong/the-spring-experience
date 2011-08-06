package   org.springsource.examples.expenses.model ;import java.util.*;import javax.persistence.*;        import javax.persistence.Column;   import javax.persistence.Entity;   import javax.persistence.FetchType;   import javax.persistence.Id;   import javax.persistence.JoinColumn;   import javax.persistence.ManyToOne;   import javax.persistence.Table;     /**   @author Josh Long    */  @Entity @EntityListeners(org.springsource.examples.expenses.services.util.AuditingJpaEntityFieldListener.class)   @Table(name="credit_card"      ,schema="public"  )  public class CreditCard  implements java.io.Serializable {           private long creditCardId;       private ExpenseHolder expenseHolder;        public CreditCard() {      }        public CreditCard(long creditCardId, ExpenseHolder expenseHolder) {         this.creditCardId = creditCardId;         this.expenseHolder = expenseHolder;      }            
    
   private java.util.Date dateCreated ;
   @Temporal(TemporalType.TIMESTAMP) @Column(name="date_created", nullable=false, length=10)
   public Date getDateCreated() { return this.dateCreated; }
   public void setDateCreated(Date dc) { this.dateCreated =dc; }

   
   private java.util.Date dateModified;
   @Temporal(TemporalType.TIMESTAMP) @Column(name="date_modified", nullable=false, length=10)
   public Date getDateModified() { return this.dateModified; }
   public void setDateModified(Date dc) { this.dateModified =dc; }
    
        
    private java.lang.Long version;
     @javax.persistence.Version   public java.lang.Long getVersion() { return version; }
    public void setVersion(java.lang.Long value) { this.version = value; }
     @Id    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO) @Column(name="credit_card_id", unique=true, nullable=false)      public long getCreditCardId() {          return this.creditCardId;      }            public void setCreditCardId(long creditCardId) {          this.creditCardId = creditCardId;      }  @ManyToOne(fetch=FetchType.LAZY)      @JoinColumn(name="expense_holder_id", nullable=false)      public ExpenseHolder getExpenseHolder() {          return this.expenseHolder;      }            public void setExpenseHolder(ExpenseHolder expenseHolder) {          this.expenseHolder = expenseHolder;      }          }     