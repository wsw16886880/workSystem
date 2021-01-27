package com.worksystem.entity;

import java.util.ArrayList;
import java.util.List;

public class SchoolTimetableExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SchoolTimetableExample() {
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

        public Criteria andStidIsNull() {
            addCriterion("stid is null");
            return (Criteria) this;
        }

        public Criteria andStidIsNotNull() {
            addCriterion("stid is not null");
            return (Criteria) this;
        }

        public Criteria andStidEqualTo(Integer value) {
            addCriterion("stid =", value, "stid");
            return (Criteria) this;
        }

        public Criteria andStidNotEqualTo(Integer value) {
            addCriterion("stid <>", value, "stid");
            return (Criteria) this;
        }

        public Criteria andStidGreaterThan(Integer value) {
            addCriterion("stid >", value, "stid");
            return (Criteria) this;
        }

        public Criteria andStidGreaterThanOrEqualTo(Integer value) {
            addCriterion("stid >=", value, "stid");
            return (Criteria) this;
        }

        public Criteria andStidLessThan(Integer value) {
            addCriterion("stid <", value, "stid");
            return (Criteria) this;
        }

        public Criteria andStidLessThanOrEqualTo(Integer value) {
            addCriterion("stid <=", value, "stid");
            return (Criteria) this;
        }

        public Criteria andStidIn(List<Integer> values) {
            addCriterion("stid in", values, "stid");
            return (Criteria) this;
        }

        public Criteria andStidNotIn(List<Integer> values) {
            addCriterion("stid not in", values, "stid");
            return (Criteria) this;
        }

        public Criteria andStidBetween(Integer value1, Integer value2) {
            addCriterion("stid between", value1, value2, "stid");
            return (Criteria) this;
        }

        public Criteria andStidNotBetween(Integer value1, Integer value2) {
            addCriterion("stid not between", value1, value2, "stid");
            return (Criteria) this;
        }

        public Criteria andStgidIsNull() {
            addCriterion("stgid is null");
            return (Criteria) this;
        }

        public Criteria andStgidIsNotNull() {
            addCriterion("stgid is not null");
            return (Criteria) this;
        }

        public Criteria andStgidEqualTo(Integer value) {
            addCriterion("stgid =", value, "stgid");
            return (Criteria) this;
        }

        public Criteria andStgidNotEqualTo(Integer value) {
            addCriterion("stgid <>", value, "stgid");
            return (Criteria) this;
        }

        public Criteria andStgidGreaterThan(Integer value) {
            addCriterion("stgid >", value, "stgid");
            return (Criteria) this;
        }

        public Criteria andStgidGreaterThanOrEqualTo(Integer value) {
            addCriterion("stgid >=", value, "stgid");
            return (Criteria) this;
        }

        public Criteria andStgidLessThan(Integer value) {
            addCriterion("stgid <", value, "stgid");
            return (Criteria) this;
        }

        public Criteria andStgidLessThanOrEqualTo(Integer value) {
            addCriterion("stgid <=", value, "stgid");
            return (Criteria) this;
        }

        public Criteria andStgidIn(List<Integer> values) {
            addCriterion("stgid in", values, "stgid");
            return (Criteria) this;
        }

        public Criteria andStgidNotIn(List<Integer> values) {
            addCriterion("stgid not in", values, "stgid");
            return (Criteria) this;
        }

        public Criteria andStgidBetween(Integer value1, Integer value2) {
            addCriterion("stgid between", value1, value2, "stgid");
            return (Criteria) this;
        }

        public Criteria andStgidNotBetween(Integer value1, Integer value2) {
            addCriterion("stgid not between", value1, value2, "stgid");
            return (Criteria) this;
        }

        public Criteria andStsemesterIsNull() {
            addCriterion("stsemester is null");
            return (Criteria) this;
        }

        public Criteria andStsemesterIsNotNull() {
            addCriterion("stsemester is not null");
            return (Criteria) this;
        }

        public Criteria andStsemesterEqualTo(Integer value) {
            addCriterion("stsemester =", value, "stsemester");
            return (Criteria) this;
        }

        public Criteria andStsemesterNotEqualTo(Integer value) {
            addCriterion("stsemester <>", value, "stsemester");
            return (Criteria) this;
        }

        public Criteria andStsemesterGreaterThan(Integer value) {
            addCriterion("stsemester >", value, "stsemester");
            return (Criteria) this;
        }

        public Criteria andStsemesterGreaterThanOrEqualTo(Integer value) {
            addCriterion("stsemester >=", value, "stsemester");
            return (Criteria) this;
        }

        public Criteria andStsemesterLessThan(Integer value) {
            addCriterion("stsemester <", value, "stsemester");
            return (Criteria) this;
        }

        public Criteria andStsemesterLessThanOrEqualTo(Integer value) {
            addCriterion("stsemester <=", value, "stsemester");
            return (Criteria) this;
        }

        public Criteria andStsemesterIn(List<Integer> values) {
            addCriterion("stsemester in", values, "stsemester");
            return (Criteria) this;
        }

        public Criteria andStsemesterNotIn(List<Integer> values) {
            addCriterion("stsemester not in", values, "stsemester");
            return (Criteria) this;
        }

        public Criteria andStsemesterBetween(Integer value1, Integer value2) {
            addCriterion("stsemester between", value1, value2, "stsemester");
            return (Criteria) this;
        }

        public Criteria andStsemesterNotBetween(Integer value1, Integer value2) {
            addCriterion("stsemester not between", value1, value2, "stsemester");
            return (Criteria) this;
        }

        public Criteria andStfileIsNull() {
            addCriterion("stfile is null");
            return (Criteria) this;
        }

        public Criteria andStfileIsNotNull() {
            addCriterion("stfile is not null");
            return (Criteria) this;
        }

        public Criteria andStfileEqualTo(String value) {
            addCriterion("stfile =", value, "stfile");
            return (Criteria) this;
        }

        public Criteria andStfileNotEqualTo(String value) {
            addCriterion("stfile <>", value, "stfile");
            return (Criteria) this;
        }

        public Criteria andStfileGreaterThan(String value) {
            addCriterion("stfile >", value, "stfile");
            return (Criteria) this;
        }

        public Criteria andStfileGreaterThanOrEqualTo(String value) {
            addCriterion("stfile >=", value, "stfile");
            return (Criteria) this;
        }

        public Criteria andStfileLessThan(String value) {
            addCriterion("stfile <", value, "stfile");
            return (Criteria) this;
        }

        public Criteria andStfileLessThanOrEqualTo(String value) {
            addCriterion("stfile <=", value, "stfile");
            return (Criteria) this;
        }

        public Criteria andStfileLike(String value) {
            addCriterion("stfile like", value, "stfile");
            return (Criteria) this;
        }

        public Criteria andStfileNotLike(String value) {
            addCriterion("stfile not like", value, "stfile");
            return (Criteria) this;
        }

        public Criteria andStfileIn(List<String> values) {
            addCriterion("stfile in", values, "stfile");
            return (Criteria) this;
        }

        public Criteria andStfileNotIn(List<String> values) {
            addCriterion("stfile not in", values, "stfile");
            return (Criteria) this;
        }

        public Criteria andStfileBetween(String value1, String value2) {
            addCriterion("stfile between", value1, value2, "stfile");
            return (Criteria) this;
        }

        public Criteria andStfileNotBetween(String value1, String value2) {
            addCriterion("stfile not between", value1, value2, "stfile");
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