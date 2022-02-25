package repository;

import argumentresolver.ReservationParam;
import argumentresolver.ReservationPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcInsertOperations;

import javax.sql.DataSource;
import java.util.Date;

public class ReservationRepositoryImpl implements ReservationRepository {
    NamedParameterJdbcTemplate jdbcTemplate;
    DataSource dataSource;

    @Autowired
    public ReservationRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    @Override
    public int saveReservationInfo(ReservationParam reservationParam) {
        SimpleJdbcInsertOperations reservationInfoTable = new SimpleJdbcInsert(dataSource)
                .withTableName("reservation_info")
                .usingGeneratedKeyColumns("id");

        SqlParameterSource infoParams = new MapSqlParameterSource()
                .addValue("product_id", reservationParam.getProductId())
                .addValue("display_info_id", reservationParam.getDisplayInfoId())
                .addValue("reservation_name", reservationParam.getReservationName())
                .addValue("reservation_tel", reservationParam.getReservationTelephone())
                .addValue("reservation_email", reservationParam.getReservationEmail())
                .addValue("reservation_date", reservationParam.getReservationYearMonthDay())
                .addValue("create_date", new Date())
                .addValue("modify_date", new Date());

        return reservationInfoTable.executeAndReturnKey(infoParams).intValue();
    }

    @Override
    public int saveReservationInfoPrice(int reservation) {
        SimpleJdbcInsertOperations reservationInfoPriceTable = new SimpleJdbcInsert(dataSource)
                .withTableName("reservation_info_price");

        SqlParameterSource paramPriceParams = new BeanPropertySqlParameterSource(ReservationPrice.class);

        return reservationInfoPriceTable.executeAndReturnKey(paramPriceParams).intValue();
    }
}
