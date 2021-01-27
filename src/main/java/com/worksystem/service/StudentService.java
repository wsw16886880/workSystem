package com.worksystem.service;

import com.worksystem.entity.Student;
import com.worksystem.entity.StudentExample;
import com.worksystem.exception.StudentRuntimeException;
import com.worksystem.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    private final StudentMapper studentMapper;

    @Autowired
    public StudentService(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public Student login(Student student) throws StudentRuntimeException {
        StudentExample example = new StudentExample();
        // 设置条件，判断账号是否存在
        example.or().andSnumberEqualTo(student.getSnumber());
        if (studentMapper.selectByExample(example).size() <= 0) {
            throw new StudentRuntimeException("该学号不存在！");
        }
        // 清除条件，重新设置
        example.clear();
        // 设置条件，查询数据库
        example.or().andSnumberEqualTo(student.getSnumber()).andSpwdEqualTo(student.getSpwd());
        List<Student> students = studentMapper.selectByExample(example);
        // 判断密码是否正确
        if(students.size() <= 0) {
            throw new StudentRuntimeException("密码错误！");
        }
        return students.get(0);
    }

    public List<Student> checkWXBindNumber(String openId){
        StudentExample example = new StudentExample();
        // 设置条件，判断该微信账号是否绑定了学号
        example.or().andOpenidEqualTo(openId);
        // 调用mapper中的方法查找数据库
        return studentMapper.selectByExample(example);
    }

    /**
     * 伪批量添加数据
     * @param students
     * @return
     */
    public int insertBatch(List<Student> students) {
        int result = 0;
        for (Student student : students) {
            result += studentMapper.insert(student);
        }
        return result;
    }

    /**
     * 添加 单条 数据
     * @param student
     * @return
     */
    public int insert(Student student) {
        return studentMapper.insert(student);
    }

    /**
     * 根据 主键 查询单条数据
     * @param sid
     * @return
     */
    public Student selectByPrimaryKey(Integer sid) {
        return studentMapper.selectByPrimaryKey(sid);
    }

    /**
     * 根据 班级id 查询所有数据
     * @return List<Student>
     */
    public List<Student> selectByGid(Integer gid) {
        StudentExample example = new StudentExample();
        // 设置条件
        example.or().andSgidEqualTo(gid.toString());
        return studentMapper.selectByExample(example);
    }

    /**
     * 查询所有的学生和所在的班级名称
     * @return
     */
    public List<Map<String, Object>> selectAndGname() {
        return studentMapper.selectAndGname(null);
    }

    public List<Map<String, Object>> selectAndGname(Integer gid) {
        StudentExample example = new StudentExample();
        example.or().andSgidEqualTo(gid.toString());
        return studentMapper.selectAndGname(example);
    }

    /**
     * 根据 主键 修改单条记录中的所有字段
     * @param student
     * @return
     */
    public int updateByPrimaryKey(Student student) {
        return studentMapper.updateByPrimaryKey(student);
    }

    /**
     * 选择性更改数据
     * 根据 主键 更改数据，更改属性不为空的字段
     * @param student
     * @return
     */
    public int updateByPrimaryKeySelective(Student student) {
        StudentExample example = new StudentExample();
        // 设置条件
        example.or().andSidEqualTo(student.getSid());
        // 连接数据库，更改数据
        return studentMapper.updateByExampleSelective(student,example);
    }

    /**
     * 根据 主键 删除数据
     * @param sid
     * @return
     */
    public int deleteByPrimaryKey(Integer sid) {
        return studentMapper.deleteByPrimaryKey(sid);
    }

    /**
     * 根据 班级id 删除数据
     * @param gid
     * @return
     */
    public int deleteByGid(Integer gid) {
        StudentExample example = new StudentExample();
        // 设置条件
        example.or().andSgidEqualTo(gid.toString());
        return studentMapper.deleteByExample(example);
    }
}
