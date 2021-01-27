package com.worksystem.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class LateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LateExample() {
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

        public Criteria andLidIsNull() {
            addCriterion("lid is null");
            return (Criteria) this;
        }

        public Criteria andLidIsNotNull() {
            addCriterion("lid is not null");
            return (Criteria) this;
        }

        public Criteria andLidEqualTo(Integer value) {
            addCriterion("lid =", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidNotEqualTo(Integer value) {
            addCriterion("lid <>", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidGreaterThan(Integer value) {
            addCriterion("lid >", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidGreaterThanOrEqualTo(Integer value) {
            addCriterion("lid >=", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidLessThan(Integer value) {
            addCriterion("lid <", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidLessThanOrEqualTo(Integer value) {
            addCriterion("lid <=", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidIn(List<Integer> values) {
            addCriterion("lid in", values, "lid");
            return (Criteria) this;
        }

        public Criteria andLidNotIn(List<Integer> values) {
            addCriterion("lid not in", values, "lid");
            return (Criteria) this;
        }

        public Criteria andLidBetween(Integer value1, Integer value2) {
            addCriterion("lid between", value1, value2, "lid");
            return (Criteria) this;
        }

        public Criteria andLidNotBetween(Integer value1, Integer value2) {
            addCriterion("lid not between", value1, value2, "lid");
            return (Criteria) this;
        }

        public Criteria andLtidIsNull() {
            addCriterion("ltid is null");
            return (Criteria) this;
        }

        public Criteria andLtidIsNotNull() {
            addCriterion("ltid is not null");
            return (Criteria) this;
        }

        public Criteria andLtidEqualTo(Integer value) {
            addCriterion("ltid =", value, "ltid");
            return (Criteria) this;
        }

        public Criteria andLtidNotEqualTo(Integer value) {
            addCriterion("ltid <>", value, "ltid");
            return (Criteria) this;
        }

        public Criteria andLtidGreaterThan(Integer value) {
            addCriterion("ltid >", value, "ltid");
            return (Criteria) this;
        }

        public Criteria andLtidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ltid >=", value, "ltid");
            return (Criteria) this;
        }

        public Criteria andLtidLessThan(Integer value) {
            addCriterion("ltid <", value, "ltid");
            return (Criteria) this;
        }

        public Criteria andLtidLessThanOrEqualTo(Integer value) {
            addCriterion("ltid <=", value, "ltid");
            return (Criteria) this;
        }

        public Criteria andLtidIn(List<Integer> values) {
            addCriterion("ltid in", values, "ltid");
            return (Criteria) this;
        }

        public Criteria andLtidNotIn(List<Integer> values) {
            addCriterion("ltid not in", values, "ltid");
            return (Criteria) this;
        }

        public Criteria andLtidBetween(Integer value1, Integer value2) {
            addCriterion("ltid between", value1, value2, "ltid");
            return (Criteria) this;
        }

        public Criteria andLtidNotBetween(Integer value1, Integer value2) {
            addCriterion("ltid not between", value1, value2, "ltid");
            return (Criteria) this;
        }

        public Criteria andLsidIsNull() {
            addCriterion("lsid is null");
            return (Criteria) this;
        }

        public Criteria andLsidIsNotNull() {
            addCriterion("lsid is not null");
            return (Criteria) this;
        }

        public Criteria andLsidEqualTo(Integer value) {
            addCriterion("lsid =", value, "lsid");
            return (Criteria) this;
        }

        public Criteria andLsidNotEqualTo(Integer value) {
            addCriterion("lsid <>", value, "lsid");
            return (Criteria) this;
        }

        public Criteria andLsidGreaterThan(Integer value) {
            addCriterion("lsid >", value, "lsid");
            return (Criteria) this;
        }

        public Criteria andLsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("lsid >=", value, "lsid");
            return (Criteria) this;
        }

        public Criteria andLsidLessThan(Integer value) {
            addCriterion("lsid <", value, "lsid");
            return (Criteria) this;
        }

        public Criteria andLsidLessThanOrEqualTo(Integer value) {
            addCriterion("lsid <=", value, "lsid");
            return (Criteria) this;
        }

        public Criteria andLsidIn(List<Integer> values) {
            addCriterion("lsid in", values, "lsid");
            return (Criteria) this;
        }

        public Criteria andLsidNotIn(List<Integer> values) {
            addCriterion("lsid not in", values, "lsid");
            return (Criteria) this;
        }

        public Criteria andLsidBetween(Integer value1, Integer value2) {
            addCriterion("lsid between", value1, value2, "lsid");
            return (Criteria) this;
        }

        public Criteria andLsidNotBetween(Integer value1, Integer value2) {
            addCriterion("lsid not between", value1, value2, "lsid");
            return (Criteria) this;
        }

        public Criteria andLgidIsNull() {
            addCriterion("lgid is null");
            return (Criteria) this;
        }

        public Criteria andLgidIsNotNull() {
            addCriterion("lgid is not null");
            return (Criteria) this;
        }

        public Criteria andLgidEqualTo(Integer value) {
            addCriterion("lgid =", value, "lgid");
            return (Criteria) this;
        }

        public Criteria andLgidNotEqualTo(Integer value) {
            addCriterion("lgid <>", value, "lgid");
            return (Criteria) this;
        }

        public Criteria andLgidGreaterThan(Integer value) {
            addCriterion("lgid >", value, "lgid");
            return (Criteria) this;
        }

        public Criteria andLgidGreaterThanOrEqualTo(Integer value) {
            addCriterion("lgid >=", value, "lgid");
            return (Criteria) this;
        }

        public Criteria andLgidLessThan(Integer value) {
            addCriterion("lgid <", value, "lgid");
            return (Criteria) this;
        }

        public Criteria andLgidLessThanOrEqualTo(Integer value) {
            addCriterion("lgid <=", value, "lgid");
            return (Criteria) this;
        }

        public Criteria andLgidIn(List<Integer> values) {
            addCriterion("lgid in", values, "lgid");
            return (Criteria) this;
        }

        public Criteria andLgidNotIn(List<Integer> values) {
            addCriterion("lgid not in", values, "lgid");
            return (Criteria) this;
        }

        public Criteria andLgidBetween(Integer value1, Integer value2) {
            addCriterion("lgid between", value1, value2, "lgid");
            return (Criteria) this;
        }

        public Criteria andLgidNotBetween(Integer value1, Integer value2) {
            addCriterion("lgid not between", value1, value2, "lgid");
            return (Criteria) this;
        }

        public Criteria andLsnameIsNull() {
            addCriterion("lsname is null");
            return (Criteria) this;
        }

        public Criteria andLsnameIsNotNull() {
            addCriterion("lsname is not null");
            return (Criteria) this;
        }

        public Criteria andLsnameEqualTo(String value) {
            addCriterion("lsname =", value, "lsname");
            return (Criteria) this;
        }

        public Criteria andLsnameNotEqualTo(String value) {
            addCriterion("lsname <>", value, "lsname");
            return (Criteria) this;
        }

        public Criteria andLsnameGreaterThan(String value) {
            addCriterion("lsname >", value, "lsname");
            return (Criteria) this;
        }

        public Criteria andLsnameGreaterThanOrEqualTo(String value) {
            addCriterion("lsname >=", value, "lsname");
            return (Criteria) this;
        }

        public Criteria andLsnameLessThan(String value) {
            addCriterion("lsname <", value, "lsname");
            return (Criteria) this;
        }

        public Criteria andLsnameLessThanOrEqualTo(String value) {
            addCriterion("lsname <=", value, "lsname");
            return (Criteria) this;
        }

        public Criteria andLsnameLike(String value) {
            addCriterion("lsname like", value, "lsname");
            return (Criteria) this;
        }

        public Criteria andLsnameNotLike(String value) {
            addCriterion("lsname not like", value, "lsname");
            return (Criteria) this;
        }

        public Criteria andLsnameIn(List<String> values) {
            addCriterion("lsname in", values, "lsname");
            return (Criteria) this;
        }

        public Criteria andLsnameNotIn(List<String> values) {
            addCriterion("lsname not in", values, "lsname");
            return (Criteria) this;
        }

        public Criteria andLsnameBetween(String value1, String value2) {
            addCriterion("lsname between", value1, value2, "lsname");
            return (Criteria) this;
        }

        public Criteria andLsnameNotBetween(String value1, String value2) {
            addCriterion("lsname not between", value1, value2, "lsname");
            return (Criteria) this;
        }

        public Criteria andLsnumberIsNull() {
            addCriterion("lsnumber is null");
            return (Criteria) this;
        }

        public Criteria andLsnumberIsNotNull() {
            addCriterion("lsnumber is not null");
            return (Criteria) this;
        }

        public Criteria andLsnumberEqualTo(String value) {
            addCriterion("lsnumber =", value, "lsnumber");
            return (Criteria) this;
        }

        public Criteria andLsnumberNotEqualTo(String value) {
            addCriterion("lsnumber <>", value, "lsnumber");
            return (Criteria) this;
        }

        public Criteria andLsnumberGreaterThan(String value) {
            addCriterion("lsnumber >", value, "lsnumber");
            return (Criteria) this;
        }

        public Criteria andLsnumberGreaterThanOrEqualTo(String value) {
            addCriterion("lsnumber >=", value, "lsnumber");
            return (Criteria) this;
        }

        public Criteria andLsnumberLessThan(String value) {
            addCriterion("lsnumber <", value, "lsnumber");
            return (Criteria) this;
        }

        public Criteria andLsnumberLessThanOrEqualTo(String value) {
            addCriterion("lsnumber <=", value, "lsnumber");
            return (Criteria) this;
        }

        public Criteria andLsnumberLike(String value) {
            addCriterion("lsnumber like", value, "lsnumber");
            return (Criteria) this;
        }

        public Criteria andLsnumberNotLike(String value) {
            addCriterion("lsnumber not like", value, "lsnumber");
            return (Criteria) this;
        }

        public Criteria andLsnumberIn(List<String> values) {
            addCriterion("lsnumber in", values, "lsnumber");
            return (Criteria) this;
        }

        public Criteria andLsnumberNotIn(List<String> values) {
            addCriterion("lsnumber not in", values, "lsnumber");
            return (Criteria) this;
        }

        public Criteria andLsnumberBetween(String value1, String value2) {
            addCriterion("lsnumber between", value1, value2, "lsnumber");
            return (Criteria) this;
        }

        public Criteria andLsnumberNotBetween(String value1, String value2) {
            addCriterion("lsnumber not between", value1, value2, "lsnumber");
            return (Criteria) this;
        }

        public Criteria andLnameIsNull() {
            addCriterion("lname is null");
            return (Criteria) this;
        }

        public Criteria andLnameIsNotNull() {
            addCriterion("lname is not null");
            return (Criteria) this;
        }

        public Criteria andLnameEqualTo(String value) {
            addCriterion("lname =", value, "lname");
            return (Criteria) this;
        }

        public Criteria andLnameNotEqualTo(String value) {
            addCriterion("lname <>", value, "lname");
            return (Criteria) this;
        }

        public Criteria andLnameGreaterThan(String value) {
            addCriterion("lname >", value, "lname");
            return (Criteria) this;
        }

        public Criteria andLnameGreaterThanOrEqualTo(String value) {
            addCriterion("lname >=", value, "lname");
            return (Criteria) this;
        }

        public Criteria andLnameLessThan(String value) {
            addCriterion("lname <", value, "lname");
            return (Criteria) this;
        }

        public Criteria andLnameLessThanOrEqualTo(String value) {
            addCriterion("lname <=", value, "lname");
            return (Criteria) this;
        }

        public Criteria andLnameLike(String value) {
            addCriterion("lname like", value, "lname");
            return (Criteria) this;
        }

        public Criteria andLnameNotLike(String value) {
            addCriterion("lname not like", value, "lname");
            return (Criteria) this;
        }

        public Criteria andLnameIn(List<String> values) {
            addCriterion("lname in", values, "lname");
            return (Criteria) this;
        }

        public Criteria andLnameNotIn(List<String> values) {
            addCriterion("lname not in", values, "lname");
            return (Criteria) this;
        }

        public Criteria andLnameBetween(String value1, String value2) {
            addCriterion("lname between", value1, value2, "lname");
            return (Criteria) this;
        }

        public Criteria andLnameNotBetween(String value1, String value2) {
            addCriterion("lname not between", value1, value2, "lname");
            return (Criteria) this;
        }

        public Criteria andLwidIsNull() {
            addCriterion("lwid is null");
            return (Criteria) this;
        }

        public Criteria andLwidIsNotNull() {
            addCriterion("lwid is not null");
            return (Criteria) this;
        }

        public Criteria andLwidEqualTo(Integer value) {
            addCriterion("lwid =", value, "lwid");
            return (Criteria) this;
        }

        public Criteria andLwidNotEqualTo(Integer value) {
            addCriterion("lwid <>", value, "lwid");
            return (Criteria) this;
        }

        public Criteria andLwidGreaterThan(Integer value) {
            addCriterion("lwid >", value, "lwid");
            return (Criteria) this;
        }

        public Criteria andLwidGreaterThanOrEqualTo(Integer value) {
            addCriterion("lwid >=", value, "lwid");
            return (Criteria) this;
        }

        public Criteria andLwidLessThan(Integer value) {
            addCriterion("lwid <", value, "lwid");
            return (Criteria) this;
        }

        public Criteria andLwidLessThanOrEqualTo(Integer value) {
            addCriterion("lwid <=", value, "lwid");
            return (Criteria) this;
        }

        public Criteria andLwidIn(List<Integer> values) {
            addCriterion("lwid in", values, "lwid");
            return (Criteria) this;
        }

        public Criteria andLwidNotIn(List<Integer> values) {
            addCriterion("lwid not in", values, "lwid");
            return (Criteria) this;
        }

        public Criteria andLwidBetween(Integer value1, Integer value2) {
            addCriterion("lwid between", value1, value2, "lwid");
            return (Criteria) this;
        }

        public Criteria andLwidNotBetween(Integer value1, Integer value2) {
            addCriterion("lwid not between", value1, value2, "lwid");
            return (Criteria) this;
        }

        public Criteria andIssubmitIsNull() {
            addCriterion("issubmit is null");
            return (Criteria) this;
        }

        public Criteria andIssubmitIsNotNull() {
            addCriterion("issubmit is not null");
            return (Criteria) this;
        }

        public Criteria andIssubmitEqualTo(String value) {
            addCriterion("issubmit =", value, "issubmit");
            return (Criteria) this;
        }

        public Criteria andIssubmitNotEqualTo(String value) {
            addCriterion("issubmit <>", value, "issubmit");
            return (Criteria) this;
        }

        public Criteria andIssubmitGreaterThan(String value) {
            addCriterion("issubmit >", value, "issubmit");
            return (Criteria) this;
        }

        public Criteria andIssubmitGreaterThanOrEqualTo(String value) {
            addCriterion("issubmit >=", value, "issubmit");
            return (Criteria) this;
        }

        public Criteria andIssubmitLessThan(String value) {
            addCriterion("issubmit <", value, "issubmit");
            return (Criteria) this;
        }

        public Criteria andIssubmitLessThanOrEqualTo(String value) {
            addCriterion("issubmit <=", value, "issubmit");
            return (Criteria) this;
        }

        public Criteria andIssubmitLike(String value) {
            addCriterion("issubmit like", value, "issubmit");
            return (Criteria) this;
        }

        public Criteria andIssubmitNotLike(String value) {
            addCriterion("issubmit not like", value, "issubmit");
            return (Criteria) this;
        }

        public Criteria andIssubmitIn(List<String> values) {
            addCriterion("issubmit in", values, "issubmit");
            return (Criteria) this;
        }

        public Criteria andIssubmitNotIn(List<String> values) {
            addCriterion("issubmit not in", values, "issubmit");
            return (Criteria) this;
        }

        public Criteria andIssubmitBetween(String value1, String value2) {
            addCriterion("issubmit between", value1, value2, "issubmit");
            return (Criteria) this;
        }

        public Criteria andIssubmitNotBetween(String value1, String value2) {
            addCriterion("issubmit not between", value1, value2, "issubmit");
            return (Criteria) this;
        }

        public Criteria andLweekIsNull() {
            addCriterion("lweek is null");
            return (Criteria) this;
        }

        public Criteria andLweekIsNotNull() {
            addCriterion("lweek is not null");
            return (Criteria) this;
        }

        public Criteria andLweekEqualTo(Integer value) {
            addCriterion("lweek =", value, "lweek");
            return (Criteria) this;
        }

        public Criteria andLweekNotEqualTo(Integer value) {
            addCriterion("lweek <>", value, "lweek");
            return (Criteria) this;
        }

        public Criteria andLweekGreaterThan(Integer value) {
            addCriterion("lweek >", value, "lweek");
            return (Criteria) this;
        }

        public Criteria andLweekGreaterThanOrEqualTo(Integer value) {
            addCriterion("lweek >=", value, "lweek");
            return (Criteria) this;
        }

        public Criteria andLweekLessThan(Integer value) {
            addCriterion("lweek <", value, "lweek");
            return (Criteria) this;
        }

        public Criteria andLweekLessThanOrEqualTo(Integer value) {
            addCriterion("lweek <=", value, "lweek");
            return (Criteria) this;
        }

        public Criteria andLweekIn(List<Integer> values) {
            addCriterion("lweek in", values, "lweek");
            return (Criteria) this;
        }

        public Criteria andLweekNotIn(List<Integer> values) {
            addCriterion("lweek not in", values, "lweek");
            return (Criteria) this;
        }

        public Criteria andLweekBetween(Integer value1, Integer value2) {
            addCriterion("lweek between", value1, value2, "lweek");
            return (Criteria) this;
        }

        public Criteria andLweekNotBetween(Integer value1, Integer value2) {
            addCriterion("lweek not between", value1, value2, "lweek");
            return (Criteria) this;
        }

        public Criteria andLsjidIsNull() {
            addCriterion("lsjid is null");
            return (Criteria) this;
        }

        public Criteria andLsjidIsNotNull() {
            addCriterion("lsjid is not null");
            return (Criteria) this;
        }

        public Criteria andLsjidEqualTo(Integer value) {
            addCriterion("lsjid =", value, "lsjid");
            return (Criteria) this;
        }

        public Criteria andLsjidNotEqualTo(Integer value) {
            addCriterion("lsjid <>", value, "lsjid");
            return (Criteria) this;
        }

        public Criteria andLsjidGreaterThan(Integer value) {
            addCriterion("lsjid >", value, "lsjid");
            return (Criteria) this;
        }

        public Criteria andLsjidGreaterThanOrEqualTo(Integer value) {
            addCriterion("lsjid >=", value, "lsjid");
            return (Criteria) this;
        }

        public Criteria andLsjidLessThan(Integer value) {
            addCriterion("lsjid <", value, "lsjid");
            return (Criteria) this;
        }

        public Criteria andLsjidLessThanOrEqualTo(Integer value) {
            addCriterion("lsjid <=", value, "lsjid");
            return (Criteria) this;
        }

        public Criteria andLsjidIn(List<Integer> values) {
            addCriterion("lsjid in", values, "lsjid");
            return (Criteria) this;
        }

        public Criteria andLsjidNotIn(List<Integer> values) {
            addCriterion("lsjid not in", values, "lsjid");
            return (Criteria) this;
        }

        public Criteria andLsjidBetween(Integer value1, Integer value2) {
            addCriterion("lsjid between", value1, value2, "lsjid");
            return (Criteria) this;
        }

        public Criteria andLsjidNotBetween(Integer value1, Integer value2) {
            addCriterion("lsjid not between", value1, value2, "lsjid");
            return (Criteria) this;
        }

        public Criteria andLsjnameIsNull() {
            addCriterion("lsjname is null");
            return (Criteria) this;
        }

        public Criteria andLsjnameIsNotNull() {
            addCriterion("lsjname is not null");
            return (Criteria) this;
        }

        public Criteria andLsjnameEqualTo(String value) {
            addCriterion("lsjname =", value, "lsjname");
            return (Criteria) this;
        }

        public Criteria andLsjnameNotEqualTo(String value) {
            addCriterion("lsjname <>", value, "lsjname");
            return (Criteria) this;
        }

        public Criteria andLsjnameGreaterThan(String value) {
            addCriterion("lsjname >", value, "lsjname");
            return (Criteria) this;
        }

        public Criteria andLsjnameGreaterThanOrEqualTo(String value) {
            addCriterion("lsjname >=", value, "lsjname");
            return (Criteria) this;
        }

        public Criteria andLsjnameLessThan(String value) {
            addCriterion("lsjname <", value, "lsjname");
            return (Criteria) this;
        }

        public Criteria andLsjnameLessThanOrEqualTo(String value) {
            addCriterion("lsjname <=", value, "lsjname");
            return (Criteria) this;
        }

        public Criteria andLsjnameLike(String value) {
            addCriterion("lsjname like", value, "lsjname");
            return (Criteria) this;
        }

        public Criteria andLsjnameNotLike(String value) {
            addCriterion("lsjname not like", value, "lsjname");
            return (Criteria) this;
        }

        public Criteria andLsjnameIn(List<String> values) {
            addCriterion("lsjname in", values, "lsjname");
            return (Criteria) this;
        }

        public Criteria andLsjnameNotIn(List<String> values) {
            addCriterion("lsjname not in", values, "lsjname");
            return (Criteria) this;
        }

        public Criteria andLsjnameBetween(String value1, String value2) {
            addCriterion("lsjname between", value1, value2, "lsjname");
            return (Criteria) this;
        }

        public Criteria andLsjnameNotBetween(String value1, String value2) {
            addCriterion("lsjname not between", value1, value2, "lsjname");
            return (Criteria) this;
        }

        public Criteria andLtypeIsNull() {
            addCriterion("ltype is null");
            return (Criteria) this;
        }

        public Criteria andLtypeIsNotNull() {
            addCriterion("ltype is not null");
            return (Criteria) this;
        }

        public Criteria andLtypeEqualTo(String value) {
            addCriterion("ltype =", value, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeNotEqualTo(String value) {
            addCriterion("ltype <>", value, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeGreaterThan(String value) {
            addCriterion("ltype >", value, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeGreaterThanOrEqualTo(String value) {
            addCriterion("ltype >=", value, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeLessThan(String value) {
            addCriterion("ltype <", value, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeLessThanOrEqualTo(String value) {
            addCriterion("ltype <=", value, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeLike(String value) {
            addCriterion("ltype like", value, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeNotLike(String value) {
            addCriterion("ltype not like", value, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeIn(List<String> values) {
            addCriterion("ltype in", values, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeNotIn(List<String> values) {
            addCriterion("ltype not in", values, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeBetween(String value1, String value2) {
            addCriterion("ltype between", value1, value2, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeNotBetween(String value1, String value2) {
            addCriterion("ltype not between", value1, value2, "ltype");
            return (Criteria) this;
        }

        public Criteria andLfileIsNull() {
            addCriterion("lfile is null");
            return (Criteria) this;
        }

        public Criteria andLfileIsNotNull() {
            addCriterion("lfile is not null");
            return (Criteria) this;
        }

        public Criteria andLfileEqualTo(String value) {
            addCriterion("lfile =", value, "lfile");
            return (Criteria) this;
        }

        public Criteria andLfileNotEqualTo(String value) {
            addCriterion("lfile <>", value, "lfile");
            return (Criteria) this;
        }

        public Criteria andLfileGreaterThan(String value) {
            addCriterion("lfile >", value, "lfile");
            return (Criteria) this;
        }

        public Criteria andLfileGreaterThanOrEqualTo(String value) {
            addCriterion("lfile >=", value, "lfile");
            return (Criteria) this;
        }

        public Criteria andLfileLessThan(String value) {
            addCriterion("lfile <", value, "lfile");
            return (Criteria) this;
        }

        public Criteria andLfileLessThanOrEqualTo(String value) {
            addCriterion("lfile <=", value, "lfile");
            return (Criteria) this;
        }

        public Criteria andLfileLike(String value) {
            addCriterion("lfile like", value, "lfile");
            return (Criteria) this;
        }

        public Criteria andLfileNotLike(String value) {
            addCriterion("lfile not like", value, "lfile");
            return (Criteria) this;
        }

        public Criteria andLfileIn(List<String> values) {
            addCriterion("lfile in", values, "lfile");
            return (Criteria) this;
        }

        public Criteria andLfileNotIn(List<String> values) {
            addCriterion("lfile not in", values, "lfile");
            return (Criteria) this;
        }

        public Criteria andLfileBetween(String value1, String value2) {
            addCriterion("lfile between", value1, value2, "lfile");
            return (Criteria) this;
        }

        public Criteria andLfileNotBetween(String value1, String value2) {
            addCriterion("lfile not between", value1, value2, "lfile");
            return (Criteria) this;
        }

        public Criteria andLdateIsNull() {
            addCriterion("ldate is null");
            return (Criteria) this;
        }

        public Criteria andLdateIsNotNull() {
            addCriterion("ldate is not null");
            return (Criteria) this;
        }

        public Criteria andLdateEqualTo(Date value) {
            addCriterionForJDBCDate("ldate =", value, "ldate");
            return (Criteria) this;
        }

        public Criteria andLdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("ldate <>", value, "ldate");
            return (Criteria) this;
        }

        public Criteria andLdateGreaterThan(Date value) {
            addCriterionForJDBCDate("ldate >", value, "ldate");
            return (Criteria) this;
        }

        public Criteria andLdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ldate >=", value, "ldate");
            return (Criteria) this;
        }

        public Criteria andLdateLessThan(Date value) {
            addCriterionForJDBCDate("ldate <", value, "ldate");
            return (Criteria) this;
        }

        public Criteria andLdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ldate <=", value, "ldate");
            return (Criteria) this;
        }

        public Criteria andLdateIn(List<Date> values) {
            addCriterionForJDBCDate("ldate in", values, "ldate");
            return (Criteria) this;
        }

        public Criteria andLdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("ldate not in", values, "ldate");
            return (Criteria) this;
        }

        public Criteria andLdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ldate between", value1, value2, "ldate");
            return (Criteria) this;
        }

        public Criteria andLdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ldate not between", value1, value2, "ldate");
            return (Criteria) this;
        }

        public Criteria andLedateIsNull() {
            addCriterion("ledate is null");
            return (Criteria) this;
        }

        public Criteria andLedateIsNotNull() {
            addCriterion("ledate is not null");
            return (Criteria) this;
        }

        public Criteria andLedateEqualTo(Date value) {
            addCriterion("ledate =", value, "ledate");
            return (Criteria) this;
        }

        public Criteria andLedateNotEqualTo(Date value) {
            addCriterion("ledate <>", value, "ledate");
            return (Criteria) this;
        }

        public Criteria andLedateGreaterThan(Date value) {
            addCriterion("ledate >", value, "ledate");
            return (Criteria) this;
        }

        public Criteria andLedateGreaterThanOrEqualTo(Date value) {
            addCriterion("ledate >=", value, "ledate");
            return (Criteria) this;
        }

        public Criteria andLedateLessThan(Date value) {
            addCriterion("ledate <", value, "ledate");
            return (Criteria) this;
        }

        public Criteria andLedateLessThanOrEqualTo(Date value) {
            addCriterion("ledate <=", value, "ledate");
            return (Criteria) this;
        }

        public Criteria andLedateIn(List<Date> values) {
            addCriterion("ledate in", values, "ledate");
            return (Criteria) this;
        }

        public Criteria andLedateNotIn(List<Date> values) {
            addCriterion("ledate not in", values, "ledate");
            return (Criteria) this;
        }

        public Criteria andLedateBetween(Date value1, Date value2) {
            addCriterion("ledate between", value1, value2, "ledate");
            return (Criteria) this;
        }

        public Criteria andLedateNotBetween(Date value1, Date value2) {
            addCriterion("ledate not between", value1, value2, "ledate");
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