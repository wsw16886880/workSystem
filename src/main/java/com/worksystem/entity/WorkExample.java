package com.worksystem.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class WorkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andWidIsNull() {
            addCriterion("wid is null");
            return (Criteria) this;
        }

        public Criteria andWidIsNotNull() {
            addCriterion("wid is not null");
            return (Criteria) this;
        }

        public Criteria andWidEqualTo(Integer value) {
            addCriterion("wid =", value, "wid");
            return (Criteria) this;
        }

        public Criteria andWidNotEqualTo(Integer value) {
            addCriterion("wid <>", value, "wid");
            return (Criteria) this;
        }

        public Criteria andWidGreaterThan(Integer value) {
            addCriterion("wid >", value, "wid");
            return (Criteria) this;
        }

        public Criteria andWidGreaterThanOrEqualTo(Integer value) {
            addCriterion("wid >=", value, "wid");
            return (Criteria) this;
        }

        public Criteria andWidLessThan(Integer value) {
            addCriterion("wid <", value, "wid");
            return (Criteria) this;
        }

        public Criteria andWidLessThanOrEqualTo(Integer value) {
            addCriterion("wid <=", value, "wid");
            return (Criteria) this;
        }

        public Criteria andWidIn(List<Integer> values) {
            addCriterion("wid in", values, "wid");
            return (Criteria) this;
        }

        public Criteria andWidNotIn(List<Integer> values) {
            addCriterion("wid not in", values, "wid");
            return (Criteria) this;
        }

        public Criteria andWidBetween(Integer value1, Integer value2) {
            addCriterion("wid between", value1, value2, "wid");
            return (Criteria) this;
        }

        public Criteria andWidNotBetween(Integer value1, Integer value2) {
            addCriterion("wid not between", value1, value2, "wid");
            return (Criteria) this;
        }

        public Criteria andWgidIsNull() {
            addCriterion("wgid is null");
            return (Criteria) this;
        }

        public Criteria andWgidIsNotNull() {
            addCriterion("wgid is not null");
            return (Criteria) this;
        }

        public Criteria andWgidEqualTo(Integer value) {
            addCriterion("wgid =", value, "wgid");
            return (Criteria) this;
        }

        public Criteria andWgidNotEqualTo(Integer value) {
            addCriterion("wgid <>", value, "wgid");
            return (Criteria) this;
        }

        public Criteria andWgidGreaterThan(Integer value) {
            addCriterion("wgid >", value, "wgid");
            return (Criteria) this;
        }

        public Criteria andWgidGreaterThanOrEqualTo(Integer value) {
            addCriterion("wgid >=", value, "wgid");
            return (Criteria) this;
        }

        public Criteria andWgidLessThan(Integer value) {
            addCriterion("wgid <", value, "wgid");
            return (Criteria) this;
        }

        public Criteria andWgidLessThanOrEqualTo(Integer value) {
            addCriterion("wgid <=", value, "wgid");
            return (Criteria) this;
        }

        public Criteria andWgidIn(List<Integer> values) {
            addCriterion("wgid in", values, "wgid");
            return (Criteria) this;
        }

        public Criteria andWgidNotIn(List<Integer> values) {
            addCriterion("wgid not in", values, "wgid");
            return (Criteria) this;
        }

        public Criteria andWgidBetween(Integer value1, Integer value2) {
            addCriterion("wgid between", value1, value2, "wgid");
            return (Criteria) this;
        }

        public Criteria andWgidNotBetween(Integer value1, Integer value2) {
            addCriterion("wgid not between", value1, value2, "wgid");
            return (Criteria) this;
        }

        public Criteria andWnameIsNull() {
            addCriterion("wname is null");
            return (Criteria) this;
        }

        public Criteria andWnameIsNotNull() {
            addCriterion("wname is not null");
            return (Criteria) this;
        }

        public Criteria andWnameEqualTo(String value) {
            addCriterion("wname =", value, "wname");
            return (Criteria) this;
        }

        public Criteria andWnameNotEqualTo(String value) {
            addCriterion("wname <>", value, "wname");
            return (Criteria) this;
        }

        public Criteria andWnameGreaterThan(String value) {
            addCriterion("wname >", value, "wname");
            return (Criteria) this;
        }

        public Criteria andWnameGreaterThanOrEqualTo(String value) {
            addCriterion("wname >=", value, "wname");
            return (Criteria) this;
        }

        public Criteria andWnameLessThan(String value) {
            addCriterion("wname <", value, "wname");
            return (Criteria) this;
        }

        public Criteria andWnameLessThanOrEqualTo(String value) {
            addCriterion("wname <=", value, "wname");
            return (Criteria) this;
        }

        public Criteria andWnameLike(String value) {
            addCriterion("wname like", value, "wname");
            return (Criteria) this;
        }

        public Criteria andWnameNotLike(String value) {
            addCriterion("wname not like", value, "wname");
            return (Criteria) this;
        }

        public Criteria andWnameIn(List<String> values) {
            addCriterion("wname in", values, "wname");
            return (Criteria) this;
        }

        public Criteria andWnameNotIn(List<String> values) {
            addCriterion("wname not in", values, "wname");
            return (Criteria) this;
        }

        public Criteria andWnameBetween(String value1, String value2) {
            addCriterion("wname between", value1, value2, "wname");
            return (Criteria) this;
        }

        public Criteria andWnameNotBetween(String value1, String value2) {
            addCriterion("wname not between", value1, value2, "wname");
            return (Criteria) this;
        }

        public Criteria andWsjidIsNull() {
            addCriterion("wsjid is null");
            return (Criteria) this;
        }

        public Criteria andWsjidIsNotNull() {
            addCriterion("wsjid is not null");
            return (Criteria) this;
        }

        public Criteria andWsjidEqualTo(Integer value) {
            addCriterion("wsjid =", value, "wsjid");
            return (Criteria) this;
        }

        public Criteria andWsjidNotEqualTo(Integer value) {
            addCriterion("wsjid <>", value, "wsjid");
            return (Criteria) this;
        }

        public Criteria andWsjidGreaterThan(Integer value) {
            addCriterion("wsjid >", value, "wsjid");
            return (Criteria) this;
        }

        public Criteria andWsjidGreaterThanOrEqualTo(Integer value) {
            addCriterion("wsjid >=", value, "wsjid");
            return (Criteria) this;
        }

        public Criteria andWsjidLessThan(Integer value) {
            addCriterion("wsjid <", value, "wsjid");
            return (Criteria) this;
        }

        public Criteria andWsjidLessThanOrEqualTo(Integer value) {
            addCriterion("wsjid <=", value, "wsjid");
            return (Criteria) this;
        }

        public Criteria andWsjidIn(List<Integer> values) {
            addCriterion("wsjid in", values, "wsjid");
            return (Criteria) this;
        }

        public Criteria andWsjidNotIn(List<Integer> values) {
            addCriterion("wsjid not in", values, "wsjid");
            return (Criteria) this;
        }

        public Criteria andWsjidBetween(Integer value1, Integer value2) {
            addCriterion("wsjid between", value1, value2, "wsjid");
            return (Criteria) this;
        }

        public Criteria andWsjidNotBetween(Integer value1, Integer value2) {
            addCriterion("wsjid not between", value1, value2, "wsjid");
            return (Criteria) this;
        }

        public Criteria andWeekIsNull() {
            addCriterion("week is null");
            return (Criteria) this;
        }

        public Criteria andWeekIsNotNull() {
            addCriterion("week is not null");
            return (Criteria) this;
        }

        public Criteria andWeekEqualTo(Integer value) {
            addCriterion("week =", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotEqualTo(Integer value) {
            addCriterion("week <>", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekGreaterThan(Integer value) {
            addCriterion("week >", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekGreaterThanOrEqualTo(Integer value) {
            addCriterion("week >=", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekLessThan(Integer value) {
            addCriterion("week <", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekLessThanOrEqualTo(Integer value) {
            addCriterion("week <=", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekIn(List<Integer> values) {
            addCriterion("week in", values, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotIn(List<Integer> values) {
            addCriterion("week not in", values, "week");
            return (Criteria) this;
        }

        public Criteria andWeekBetween(Integer value1, Integer value2) {
            addCriterion("week between", value1, value2, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotBetween(Integer value1, Integer value2) {
            addCriterion("week not between", value1, value2, "week");
            return (Criteria) this;
        }

        public Criteria andWtypeIsNull() {
            addCriterion("wtype is null");
            return (Criteria) this;
        }

        public Criteria andWtypeIsNotNull() {
            addCriterion("wtype is not null");
            return (Criteria) this;
        }

        public Criteria andWtypeEqualTo(String value) {
            addCriterion("wtype =", value, "wtype");
            return (Criteria) this;
        }

        public Criteria andWtypeNotEqualTo(String value) {
            addCriterion("wtype <>", value, "wtype");
            return (Criteria) this;
        }

        public Criteria andWtypeGreaterThan(String value) {
            addCriterion("wtype >", value, "wtype");
            return (Criteria) this;
        }

        public Criteria andWtypeGreaterThanOrEqualTo(String value) {
            addCriterion("wtype >=", value, "wtype");
            return (Criteria) this;
        }

        public Criteria andWtypeLessThan(String value) {
            addCriterion("wtype <", value, "wtype");
            return (Criteria) this;
        }

        public Criteria andWtypeLessThanOrEqualTo(String value) {
            addCriterion("wtype <=", value, "wtype");
            return (Criteria) this;
        }

        public Criteria andWtypeLike(String value) {
            addCriterion("wtype like", value, "wtype");
            return (Criteria) this;
        }

        public Criteria andWtypeNotLike(String value) {
            addCriterion("wtype not like", value, "wtype");
            return (Criteria) this;
        }

        public Criteria andWtypeIn(List<String> values) {
            addCriterion("wtype in", values, "wtype");
            return (Criteria) this;
        }

        public Criteria andWtypeNotIn(List<String> values) {
            addCriterion("wtype not in", values, "wtype");
            return (Criteria) this;
        }

        public Criteria andWtypeBetween(String value1, String value2) {
            addCriterion("wtype between", value1, value2, "wtype");
            return (Criteria) this;
        }

        public Criteria andWtypeNotBetween(String value1, String value2) {
            addCriterion("wtype not between", value1, value2, "wtype");
            return (Criteria) this;
        }

        public Criteria andWtotalIsNull() {
            addCriterion("wtotal is null");
            return (Criteria) this;
        }

        public Criteria andWtotalIsNotNull() {
            addCriterion("wtotal is not null");
            return (Criteria) this;
        }

        public Criteria andWtotalEqualTo(Integer value) {
            addCriterion("wtotal =", value, "wtotal");
            return (Criteria) this;
        }

        public Criteria andWtotalNotEqualTo(Integer value) {
            addCriterion("wtotal <>", value, "wtotal");
            return (Criteria) this;
        }

        public Criteria andWtotalGreaterThan(Integer value) {
            addCriterion("wtotal >", value, "wtotal");
            return (Criteria) this;
        }

        public Criteria andWtotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("wtotal >=", value, "wtotal");
            return (Criteria) this;
        }

        public Criteria andWtotalLessThan(Integer value) {
            addCriterion("wtotal <", value, "wtotal");
            return (Criteria) this;
        }

        public Criteria andWtotalLessThanOrEqualTo(Integer value) {
            addCriterion("wtotal <=", value, "wtotal");
            return (Criteria) this;
        }

        public Criteria andWtotalIn(List<Integer> values) {
            addCriterion("wtotal in", values, "wtotal");
            return (Criteria) this;
        }

        public Criteria andWtotalNotIn(List<Integer> values) {
            addCriterion("wtotal not in", values, "wtotal");
            return (Criteria) this;
        }

        public Criteria andWtotalBetween(Integer value1, Integer value2) {
            addCriterion("wtotal between", value1, value2, "wtotal");
            return (Criteria) this;
        }

        public Criteria andWtotalNotBetween(Integer value1, Integer value2) {
            addCriterion("wtotal not between", value1, value2, "wtotal");
            return (Criteria) this;
        }

        public Criteria andWdateIsNull() {
            addCriterion("wdate is null");
            return (Criteria) this;
        }

        public Criteria andWdateIsNotNull() {
            addCriterion("wdate is not null");
            return (Criteria) this;
        }

        public Criteria andWdateEqualTo(Date value) {
            addCriterionForJDBCDate("wdate =", value, "wdate");
            return (Criteria) this;
        }

        public Criteria andWdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("wdate <>", value, "wdate");
            return (Criteria) this;
        }

        public Criteria andWdateGreaterThan(Date value) {
            addCriterionForJDBCDate("wdate >", value, "wdate");
            return (Criteria) this;
        }

        public Criteria andWdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("wdate >=", value, "wdate");
            return (Criteria) this;
        }

        public Criteria andWdateLessThan(Date value) {
            addCriterionForJDBCDate("wdate <", value, "wdate");
            return (Criteria) this;
        }

        public Criteria andWdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("wdate <=", value, "wdate");
            return (Criteria) this;
        }

        public Criteria andWdateIn(List<Date> values) {
            addCriterionForJDBCDate("wdate in", values, "wdate");
            return (Criteria) this;
        }

        public Criteria andWdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("wdate not in", values, "wdate");
            return (Criteria) this;
        }

        public Criteria andWdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("wdate between", value1, value2, "wdate");
            return (Criteria) this;
        }

        public Criteria andWdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("wdate not between", value1, value2, "wdate");
            return (Criteria) this;
        }

        public Criteria andWfileIsNull() {
            addCriterion("wfile is null");
            return (Criteria) this;
        }

        public Criteria andWfileIsNotNull() {
            addCriterion("wfile is not null");
            return (Criteria) this;
        }

        public Criteria andWfileEqualTo(String value) {
            addCriterion("wfile =", value, "wfile");
            return (Criteria) this;
        }

        public Criteria andWfileNotEqualTo(String value) {
            addCriterion("wfile <>", value, "wfile");
            return (Criteria) this;
        }

        public Criteria andWfileGreaterThan(String value) {
            addCriterion("wfile >", value, "wfile");
            return (Criteria) this;
        }

        public Criteria andWfileGreaterThanOrEqualTo(String value) {
            addCriterion("wfile >=", value, "wfile");
            return (Criteria) this;
        }

        public Criteria andWfileLessThan(String value) {
            addCriterion("wfile <", value, "wfile");
            return (Criteria) this;
        }

        public Criteria andWfileLessThanOrEqualTo(String value) {
            addCriterion("wfile <=", value, "wfile");
            return (Criteria) this;
        }

        public Criteria andWfileLike(String value) {
            addCriterion("wfile like", value, "wfile");
            return (Criteria) this;
        }

        public Criteria andWfileNotLike(String value) {
            addCriterion("wfile not like", value, "wfile");
            return (Criteria) this;
        }

        public Criteria andWfileIn(List<String> values) {
            addCriterion("wfile in", values, "wfile");
            return (Criteria) this;
        }

        public Criteria andWfileNotIn(List<String> values) {
            addCriterion("wfile not in", values, "wfile");
            return (Criteria) this;
        }

        public Criteria andWfileBetween(String value1, String value2) {
            addCriterion("wfile between", value1, value2, "wfile");
            return (Criteria) this;
        }

        public Criteria andWfileNotBetween(String value1, String value2) {
            addCriterion("wfile not between", value1, value2, "wfile");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}