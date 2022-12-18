package com.zavier.demo.mbg.mapper;

import static com.zavier.demo.mbg.mapper.TUserDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.zavier.demo.mbg.model.TUser;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface TUserMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<TUser>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-18T10:54:13.449+08:00", comments="Source Table: t_user")
    BasicColumn[] selectList = BasicColumn.columnList(id, userName, userAge);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-18T10:54:13.448+08:00", comments="Source Table: t_user")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TUserResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_age", property="userAge", jdbcType=JdbcType.INTEGER)
    })
    List<TUser> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-18T10:54:13.448+08:00", comments="Source Table: t_user")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TUserResult")
    Optional<TUser> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-18T10:54:13.448+08:00", comments="Source Table: t_user")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, TUser, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-18T10:54:13.448+08:00", comments="Source Table: t_user")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, TUser, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-18T10:54:13.448+08:00", comments="Source Table: t_user")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-18T10:54:13.448+08:00", comments="Source Table: t_user")
    default int insert(TUser row) {
        return MyBatis3Utils.insert(this::insert, row, TUser, c ->
            c.map(id).toProperty("id")
            .map(userName).toProperty("userName")
            .map(userAge).toProperty("userAge")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-18T10:54:13.448+08:00", comments="Source Table: t_user")
    default int insertMultiple(Collection<TUser> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, TUser, c ->
            c.map(id).toProperty("id")
            .map(userName).toProperty("userName")
            .map(userAge).toProperty("userAge")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-18T10:54:13.449+08:00", comments="Source Table: t_user")
    default int insertSelective(TUser row) {
        return MyBatis3Utils.insert(this::insert, row, TUser, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(userName).toPropertyWhenPresent("userName", row::getUserName)
            .map(userAge).toPropertyWhenPresent("userAge", row::getUserAge)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-18T10:54:13.449+08:00", comments="Source Table: t_user")
    default Optional<TUser> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, TUser, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-18T10:54:13.449+08:00", comments="Source Table: t_user")
    default List<TUser> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, TUser, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-18T10:54:13.449+08:00", comments="Source Table: t_user")
    default List<TUser> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, TUser, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-18T10:54:13.449+08:00", comments="Source Table: t_user")
    default Optional<TUser> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-18T10:54:13.449+08:00", comments="Source Table: t_user")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, TUser, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-18T10:54:13.449+08:00", comments="Source Table: t_user")
    static UpdateDSL<UpdateModel> updateAllColumns(TUser row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(userName).equalTo(row::getUserName)
                .set(userAge).equalTo(row::getUserAge);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-18T10:54:13.449+08:00", comments="Source Table: t_user")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(TUser row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(userName).equalToWhenPresent(row::getUserName)
                .set(userAge).equalToWhenPresent(row::getUserAge);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-18T10:54:13.449+08:00", comments="Source Table: t_user")
    default int updateByPrimaryKey(TUser row) {
        return update(c ->
            c.set(userName).equalTo(row::getUserName)
            .set(userAge).equalTo(row::getUserAge)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-18T10:54:13.449+08:00", comments="Source Table: t_user")
    default int updateByPrimaryKeySelective(TUser row) {
        return update(c ->
            c.set(userName).equalToWhenPresent(row::getUserName)
            .set(userAge).equalToWhenPresent(row::getUserAge)
            .where(id, isEqualTo(row::getId))
        );
    }
}