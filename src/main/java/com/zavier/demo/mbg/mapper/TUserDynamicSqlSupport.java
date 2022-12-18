package com.zavier.demo.mbg.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class TUserDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-18T10:54:13.447+08:00", comments="Source Table: t_user")
    public static final TUser TUser = new TUser();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-18T10:54:13.447+08:00", comments="Source field: t_user.id")
    public static final SqlColumn<Integer> id = TUser.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-18T10:54:13.448+08:00", comments="Source field: t_user.user_name")
    public static final SqlColumn<String> userName = TUser.userName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-18T10:54:13.448+08:00", comments="Source field: t_user.user_age")
    public static final SqlColumn<Integer> userAge = TUser.userAge;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-18T10:54:13.447+08:00", comments="Source Table: t_user")
    public static final class TUser extends AliasableSqlTable<TUser> {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> userName = column("user_name", JDBCType.VARCHAR);

        public final SqlColumn<Integer> userAge = column("user_age", JDBCType.INTEGER);

        public TUser() {
            super("t_user", TUser::new);
        }
    }
}