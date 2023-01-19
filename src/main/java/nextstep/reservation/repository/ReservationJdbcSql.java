package nextstep.reservation.repository;

public final class ReservationJdbcSql {
    public static final String INSERT_INTO_STATEMENT = "INSERT INTO reservation (schedule_id, member_id) VALUES (?, ?);";
    public static final String SELECT_BY_THEME_ID_AND_DATE_STATEMENT = "SELECT reservation.id, " +
            "member.id, member.username, member.password, member.phone, member.name, " +
            "schedule.id, schedule.theme_id, schedule.date, schedule.time, " +
            "theme.id, theme.name, theme.desc, theme.price " +
            "from reservation " +
            "inner join schedule on reservation.schedule_id = schedule.id " +
            "inner join theme on schedule.theme_id = theme.id " +
            "inner join member on reservation.member_id = member.id " +
            "where theme.id = ? and schedule.date = ?;";

    public static final String SELECT_BY_RESERVATION_ID_STATEMENT = "SELECT reservation.id, " +
            "member.id, member.username, member.password, member.phone, member.name, " +
            "schedule.id, schedule.theme_id, schedule.date, schedule.time, " +
            "theme.id, theme.name, theme.desc, theme.price " +
            "from reservation " +
            "inner join schedule on reservation.schedule_id = schedule.id " +
            "inner join theme on schedule.theme_id = theme.id " +
            "inner join member on reservation.member_id = member.id " +
            "where reservation.id = ?;";

    public static final String SELECT_BY_SCHEDULE_ID_STATEMENT = "SELECT reservation.id, " +
            "member.id, member.username, member.password, member.phone, member.name, " +
            "schedule.id, schedule.theme_id, schedule.date, schedule.time, " +
            "theme.id, theme.name, theme.desc, theme.price " +
            "from reservation " +
            "inner join schedule on reservation.schedule_id = schedule.id " +
            "inner join theme on schedule.theme_id = theme.id " +
            "inner join member on reservation.member_id = member.id " +
            "where schedule.id = ?;";

    public static final String DELETE_BY_ID_STATEMENT = "DELETE FROM reservation where id = ?;";

    private ReservationJdbcSql() {}
}
