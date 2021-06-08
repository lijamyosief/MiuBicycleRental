package edu.miu.seniorproject.eBicycleRental.utility;
import org.springframework.core.convert.converter.Converter;

public class StringToBooking implements Converter<String, BookingEnum> {

//    private ObjectMapper objectMapper;
//
//    @Override
//    public Booking convert(String source) {
//        Booking booking=null;
//        try {
//             booking= objectMapper.readValue(source,Booking.class);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        return booking;
//
//    }

//    private static final Logger LOG = LoggerFactory.getLogger(Booking.class);
//
//    public Booking convert(String source) {
//        LOG.debug("source: {}", source);
//        if (!StringUtils.hasText(source)) {
//            return null;
//        }
//        return new Booking(source.trim(), source.trim(),source.trim(),source.trim(), source.trim(),source.trim());
//    }

    @Override
    public BookingEnum convert(String from) {
        return BookingEnum.valueOf(from);
    }

}

