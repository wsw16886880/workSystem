package com.worksystem.entity;

import java.util.ArrayList;
import java.util.List;

public class SubjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SubjectExample() {
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

        public Criteria andSjidIsNull() {
            addCriterion("sjid is null");
            return (Criteria) this;
        }

        public Criteria andSjidIsNotNull() {
            addCriterion("sjid is not null");
            return (Criteria) this;
        }

        public Criteria andSjidEqualTo(Integer value) {
            addCriterion("sjid =", value, "sjid");
            return (Criteria) this;
        }

        public Criteria andSjidNotEqualTo(Integer value) {
            addCriterion("sjid <>", value, "sjid");
            return (Criteria) this;
        }

        public Criteria andSjidGreaterThan(Integer value) {
            addCriterion("sjid >", value, "sjid");
            return (Criteria) this;
        }

        public Criteria andSjidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sjid >=", value, "sjid");
            return (Criteria) this;
        }

        public Criteria andSjidLessThan(Integer value) {
            addCriterion("sjid <", value, "sjid");
            return (Criteria) this;
        }

        public Criteria andSjidLessThanOrEqualTo(Integer value) {
            addCriterion("sjid <=", value, "sjid");
            return (Criteria) this;
        }

        public Criteria andSjidIn(List<Integer> values) {
            addCriterion("sjid in", values, "sjid");
            return (Criteria) this;
        }

        public Criteria andSjidNotIn(List<Integer> values) {
            addCriterion("sjid not in", values, "sjid");
            return (Criteria) this;
        }

        public Criteria andSjidBetween(Integer value1, Integer value2) {
            addCriterion("sjid between", value1, value2, "sjid");
            return (Criteria) this;
        }

        public Criteria andSjidNotBetween(Integer value1, Integer value2) {
            addCriterion("sjid not between", value1, value2, "sjid");
            return (Criteria) this;
        }

        public Criteria andSjnameIsNull() {
            addCriterion("sjname is null");
            return (Criteria) this;
        }

        public Criteria andSjnameIsNotNull() {
            addCriterion("sjname is not null");
            return (Criteria) this;
        }

        public Criteria andSjnameEqualTo(String value) {
            addCriterion("sjname =", value, "sjname");
            return (Criteria) this;
        }

        public Criteria andSjnameNotEqualTo(String value) {
            addCriterion("sjname <>", value, "sjname");
            return (Criteria) this;
        }

        public Criteria andSjnameGreaterThan(String value) {
            addCriterion("sjname >", value, "sjname");
            return (Criteria) this;
        }

        public Criteria andSjnameGreaterThanOrEqualTo(String value) {
            addCriterion("sjname >=", value, "sjname");
            return (Criteria) this;
        }

        public Criteria andSjnameLessThan(String value) {
            addCriterion("sjname <", value, "sjname");
            return (Criteria) this;
        }

        public Criteria andSjnameLessThanOrEqualTo(String value) {
            addCriterion("sjname <=", value, "sjname");
            return (Criteria) this;
        }

        public Criteria andSjnameLike(String value) {
            addCriterion("sjname like", value, "sjname");
            return (Criteria) this;
        }

        public Criteria andSjnameNotLike(String value) {
            addCriterion("sjname not like", value, "sjname");
            return (Criteria) this;
        }

        public Criteria andSjnameIn(List<String> values) {
            addCriterion("sjname in", values, "sjname");
            return (Criteria) this;
        }

        public Criteria andSjnameNotIn(List<String> values) {
            addCriterion("sjname not in", values, "sjname");
            return (Criteria) this;
        }

        public Criteria andSjnameBetween(String value1, String value2) {
            addCriterion("sjname between", value1, value2, "sjname");
            return (Criteria) this;
        }

        public Criteria andSjnameNotBetween(String value1, String value2) {
            addCriterion("sjname not between", value1, value2, "sjname");
            return (Criteria) this;
        }

        public Criteria andSjtnameIsNull() {
            addCriterion("sjtname is null");
            return (Criteria) this;
        }

        public Criteria andSjtnameIsNotNull() {
            addCriterion("sjtname is not null");
            return (Criteria) this;
        }

        public Criteria andSjtnameEqualTo(String value) {
            addCriterion("sjtname =", value, "sjtname");
            return (Criteria) this;
        }

        public Criteria andSjtnameNotEqualTo(String value) {
            addCriterion("sjtname <>", value, "sjtname");
            return (Criteria) this;
        }

        public Criteria andSjtnameGreaterThan(String value) {
            addCriterion("sjtname >", value, "sjtname");
            return (Criteria) this;
        }

        public Criteria andSjtnameGreaterThanOrEqualTo(String value) {
            addCriterion("sjtname >=", value, "sjtname");
            return (Criteria) this;
        }

        public Criteria andSjtnameLessThan(String value) {
            addCriterion("sjtname <", value, "sjtname");
            return (Criteria) this;
        }

        public Criteria andSjtnameLessThanOrEqualTo(String value) {
            addCriterion("sjtname <=", value, "sjtname");
            return (Criteria) this;
        }

        public Criteria andSjtnameLike(String value) {
            addCriterion("sjtname like", value, "sjtname");
            return (Criteria) this;
        }

        public Criteria andSjtnameNotLike(String value) {
            addCriterion("sjtname not like", value, "sjtname");
            return (Criteria) this;
        }

        public Criteria andSjtnameIn(List<String> values) {
            addCriterion("sjtname in", values, "sjtname");
            return (Criteria) this;
        }

        public Criteria andSjtnameNotIn(List<String> values) {
            addCriterion("sjtname not in", values, "sjtname");
            return (Criteria) this;
        }

        public Criteria andSjtnameBetween(String value1, String value2) {
            addCriterion("sjtname between", value1, value2, "sjtname");
            return (Criteria) this;
        }

        public Criteria andSjtnameNotBetween(String value1, String value2) {
            addCriterion("sjtname not between", value1, value2, "sjtname");
            return (Criteria) this;
        }

        public Criteria andSjtidIsNull() {
            addCriterion("sjtid is null");
            return (Criteria) this;
        }

        public Criteria andSjtidIsNotNull() {
            addCriterion("sjtid is not null");
            return (Criteria) this;
        }

        public Criteria andSjtidEqualTo(Integer value) {
            addCriterion("sjtid =", value, "sjtid");
            return (Criteria) this;
        }

        public Criteria andSjtidNotEqualTo(Integer value) {
            addCriterion("sjtid <>", value, "sjtid");
            return (Criteria) this;
        }

        public Criteria andSjtidGreaterThan(Integer value) {
            addCriterion("sjtid >", value, "sjtid");
            return (Criteria) this;
        }

        public Criteria andSjtidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sjtid >=", value, "sjtid");
            return (Criteria) this;
        }

        public Criteria andSjtidLessThan(Integer value) {
            addCriterion("sjtid <", value, "sjtid");
            return (Criteria) this;
        }

        public Criteria andSjtidLessThanOrEqualTo(Integer value) {
            addCriterion("sjtid <=", value, "sjtid");
            return (Criteria) this;
        }

        public Criteria andSjtidIn(List<Integer> values) {
            addCriterion("sjtid in", values, "sjtid");
            return (Criteria) this;
        }

        public Criteria andSjtidNotIn(List<Integer> values) {
            addCriterion("sjtid not in", values, "sjtid");
            return (Criteria) this;
        }

        public Criteria andSjtidBetween(Integer value1, Integer value2) {
            addCriterion("sjtid between", value1, value2, "sjtid");
            return (Criteria) this;
        }

        public Criteria andSjtidNotBetween(Integer value1, Integer value2) {
            addCriterion("sjtid not between", value1, value2, "sjtid");
            return (Criteria) this;
        }

        public Criteria andSjgidIsNull() {
            addCriterion("sjgid is null");
            return (Criteria) this;
        }

        public Criteria andSjgidIsNotNull() {
            addCriterion("sjgid is not null");
            return (Criteria) this;
        }

        public Criteria andSjgidEqualTo(Integer value) {
            addCriterion("sjgid =", value, "sjgid");
            return (Criteria) this;
        }

        public Criteria andSjgidNotEqualTo(Integer value) {
            addCriterion("sjgid <>", value, "sjgid");
            return (Criteria) this;
        }

        public Criteria andSjgidGreaterThan(Integer value) {
            addCriterion("sjgid >", value, "sjgid");
            return (Criteria) this;
        }

        public Criteria andSjgidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sjgid >=", value, "sjgid");
            return (Criteria) this;
        }

        public Criteria andSjgidLessThan(Integer value) {
            addCriterion("sjgid <", value, "sjgid");
            return (Criteria) this;
        }

        public Criteria andSjgidLessThanOrEqualTo(Integer value) {
            addCriterion("sjgid <=", value, "sjgid");
            return (Criteria) this;
        }

        public Criteria andSjgidIn(List<Integer> values) {
            addCriterion("sjgid in", values, "sjgid");
            return (Criteria) this;
        }

        public Criteria andSjgidNotIn(List<Integer> values) {
            addCriterion("sjgid not in", values, "sjgid");
            return (Criteria) this;
        }

        public Criteria andSjgidBetween(Integer value1, Integer value2) {
            addCriterion("sjgid between", value1, value2, "sjgid");
            return (Criteria) this;
        }

        public Criteria andSjgidNotBetween(Integer value1, Integer value2) {
            addCriterion("sjgid not between", value1, value2, "sjgid");
            return (Criteria) this;
        }

        public Criteria andSjsemesterIsNull() {
            addCriterion("sjsemester is null");
            return (Criteria) this;
        }

        public Criteria andSjsemesterIsNotNull() {
            addCriterion("sjsemester is not null");
            return (Criteria) this;
        }

        public Criteria andSjsemesterEqualTo(Integer value) {
            addCriterion("sjsemester =", value, "sjsemester");
            return (Criteria) this;
        }

        public Criteria andSjsemesterNotEqualTo(Integer value) {
            addCriterion("sjsemester <>", value, "sjsemester");
            return (Criteria) this;
        }

        public Criteria andSjsemesterGreaterThan(Integer value) {
            addCriterion("sjsemester >", value, "sjsemester");
            return (Criteria) this;
        }

        public Criteria andSjsemesterGreaterThanOrEqualTo(Integer value) {
            addCriterion("sjsemester >=", value, "sjsemester");
            return (Criteria) this;
        }

        public Criteria andSjsemesterLessThan(Integer value) {
            addCriterion("sjsemester <", value, "sjsemester");
            return (Criteria) this;
        }

        public Criteria andSjsemesterLessThanOrEqualTo(Integer value) {
            addCriterion("sjsemester <=", value, "sjsemester");
            return (Criteria) this;
        }

        public Criteria andSjsemesterIn(List<Integer> values) {
            addCriterion("sjsemester in", values, "sjsemester");
            return (Criteria) this;
        }

        public Criteria andSjsemesterNotIn(List<Integer> values) {
            addCriterion("sjsemester not in", values, "sjsemester");
            return (Criteria) this;
        }

        public Criteria andSjsemesterBetween(Integer value1, Integer value2) {
            addCriterion("sjsemester between", value1, value2, "sjsemester");
            return (Criteria) this;
        }

        public Criteria andSjsemesterNotBetween(Integer value1, Integer value2) {
            addCriterion("sjsemester not between", value1, value2, "sjsemester");
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