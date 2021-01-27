package com.worksystem.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessageExample() {
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

        public Criteria andMidIsNull() {
            addCriterion("mid is null");
            return (Criteria) this;
        }

        public Criteria andMidIsNotNull() {
            addCriterion("mid is not null");
            return (Criteria) this;
        }

        public Criteria andMidEqualTo(Integer value) {
            addCriterion("mid =", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotEqualTo(Integer value) {
            addCriterion("mid <>", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThan(Integer value) {
            addCriterion("mid >", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThanOrEqualTo(Integer value) {
            addCriterion("mid >=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThan(Integer value) {
            addCriterion("mid <", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThanOrEqualTo(Integer value) {
            addCriterion("mid <=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidIn(List<Integer> values) {
            addCriterion("mid in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotIn(List<Integer> values) {
            addCriterion("mid not in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidBetween(Integer value1, Integer value2) {
            addCriterion("mid between", value1, value2, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotBetween(Integer value1, Integer value2) {
            addCriterion("mid not between", value1, value2, "mid");
            return (Criteria) this;
        }

        public Criteria andMgidIsNull() {
            addCriterion("mgid is null");
            return (Criteria) this;
        }

        public Criteria andMgidIsNotNull() {
            addCriterion("mgid is not null");
            return (Criteria) this;
        }

        public Criteria andMgidEqualTo(Integer value) {
            addCriterion("mgid =", value, "mgid");
            return (Criteria) this;
        }

        public Criteria andMgidNotEqualTo(Integer value) {
            addCriterion("mgid <>", value, "mgid");
            return (Criteria) this;
        }

        public Criteria andMgidGreaterThan(Integer value) {
            addCriterion("mgid >", value, "mgid");
            return (Criteria) this;
        }

        public Criteria andMgidGreaterThanOrEqualTo(Integer value) {
            addCriterion("mgid >=", value, "mgid");
            return (Criteria) this;
        }

        public Criteria andMgidLessThan(Integer value) {
            addCriterion("mgid <", value, "mgid");
            return (Criteria) this;
        }

        public Criteria andMgidLessThanOrEqualTo(Integer value) {
            addCriterion("mgid <=", value, "mgid");
            return (Criteria) this;
        }

        public Criteria andMgidIn(List<Integer> values) {
            addCriterion("mgid in", values, "mgid");
            return (Criteria) this;
        }

        public Criteria andMgidNotIn(List<Integer> values) {
            addCriterion("mgid not in", values, "mgid");
            return (Criteria) this;
        }

        public Criteria andMgidBetween(Integer value1, Integer value2) {
            addCriterion("mgid between", value1, value2, "mgid");
            return (Criteria) this;
        }

        public Criteria andMgidNotBetween(Integer value1, Integer value2) {
            addCriterion("mgid not between", value1, value2, "mgid");
            return (Criteria) this;
        }

        public Criteria andMwidIsNull() {
            addCriterion("mwid is null");
            return (Criteria) this;
        }

        public Criteria andMwidIsNotNull() {
            addCriterion("mwid is not null");
            return (Criteria) this;
        }

        public Criteria andMwidEqualTo(Integer value) {
            addCriterion("mwid =", value, "mwid");
            return (Criteria) this;
        }

        public Criteria andMwidNotEqualTo(Integer value) {
            addCriterion("mwid <>", value, "mwid");
            return (Criteria) this;
        }

        public Criteria andMwidGreaterThan(Integer value) {
            addCriterion("mwid >", value, "mwid");
            return (Criteria) this;
        }

        public Criteria andMwidGreaterThanOrEqualTo(Integer value) {
            addCriterion("mwid >=", value, "mwid");
            return (Criteria) this;
        }

        public Criteria andMwidLessThan(Integer value) {
            addCriterion("mwid <", value, "mwid");
            return (Criteria) this;
        }

        public Criteria andMwidLessThanOrEqualTo(Integer value) {
            addCriterion("mwid <=", value, "mwid");
            return (Criteria) this;
        }

        public Criteria andMwidIn(List<Integer> values) {
            addCriterion("mwid in", values, "mwid");
            return (Criteria) this;
        }

        public Criteria andMwidNotIn(List<Integer> values) {
            addCriterion("mwid not in", values, "mwid");
            return (Criteria) this;
        }

        public Criteria andMwidBetween(Integer value1, Integer value2) {
            addCriterion("mwid between", value1, value2, "mwid");
            return (Criteria) this;
        }

        public Criteria andMwidNotBetween(Integer value1, Integer value2) {
            addCriterion("mwid not between", value1, value2, "mwid");
            return (Criteria) this;
        }

        public Criteria andMsidIsNull() {
            addCriterion("msid is null");
            return (Criteria) this;
        }

        public Criteria andMsidIsNotNull() {
            addCriterion("msid is not null");
            return (Criteria) this;
        }

        public Criteria andMsidEqualTo(Integer value) {
            addCriterion("msid =", value, "msid");
            return (Criteria) this;
        }

        public Criteria andMsidNotEqualTo(Integer value) {
            addCriterion("msid <>", value, "msid");
            return (Criteria) this;
        }

        public Criteria andMsidGreaterThan(Integer value) {
            addCriterion("msid >", value, "msid");
            return (Criteria) this;
        }

        public Criteria andMsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("msid >=", value, "msid");
            return (Criteria) this;
        }

        public Criteria andMsidLessThan(Integer value) {
            addCriterion("msid <", value, "msid");
            return (Criteria) this;
        }

        public Criteria andMsidLessThanOrEqualTo(Integer value) {
            addCriterion("msid <=", value, "msid");
            return (Criteria) this;
        }

        public Criteria andMsidIn(List<Integer> values) {
            addCriterion("msid in", values, "msid");
            return (Criteria) this;
        }

        public Criteria andMsidNotIn(List<Integer> values) {
            addCriterion("msid not in", values, "msid");
            return (Criteria) this;
        }

        public Criteria andMsidBetween(Integer value1, Integer value2) {
            addCriterion("msid between", value1, value2, "msid");
            return (Criteria) this;
        }

        public Criteria andMsidNotBetween(Integer value1, Integer value2) {
            addCriterion("msid not between", value1, value2, "msid");
            return (Criteria) this;
        }

        public Criteria andMtimeIsNull() {
            addCriterion("mtime is null");
            return (Criteria) this;
        }

        public Criteria andMtimeIsNotNull() {
            addCriterion("mtime is not null");
            return (Criteria) this;
        }

        public Criteria andMtimeEqualTo(Date value) {
            addCriterionForJDBCDate("mtime =", value, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("mtime <>", value, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("mtime >", value, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("mtime >=", value, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeLessThan(Date value) {
            addCriterionForJDBCDate("mtime <", value, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("mtime <=", value, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeIn(List<Date> values) {
            addCriterionForJDBCDate("mtime in", values, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("mtime not in", values, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("mtime between", value1, value2, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("mtime not between", value1, value2, "mtime");
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