package com.example.section9;

import com.example.section9.user.DupIdException;
import com.example.section9.user.UserRegister;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class UserRegisterIntTest {
    @Autowired
    private UserRegister register;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void 동일ID가_이미_존재하면_익셉션() {
        jdbcTemplate.update(
                "insert into user values (?, ?, ?) " +
                        "on duplicate key update password = ?, email = ?",
                        "cbk", "pw", "cbk@cbk.com", "pw", "cbk@cbk.com"
        );

        assertThrows(DupIdException.class, () -> register.register("cbk", "strongpw", "email@email.com"));
    }

    @Test
    void 존재하지_않으면_저장함() {
        jdbcTemplate.update("delete from user where id = ?", "cbk");

        register.register("cbk", "strongpw", "email@email.com");

        SqlRowSet rs = jdbcTemplate.queryForRowSet("select * from user where id = ?", "cbk");
        rs.next();
        assertEquals("email@email.com", rs.getString("email"));
    }
}
