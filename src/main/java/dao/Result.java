package dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by a on 18.09.16.
 */
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private char[] line0;
    private char[] line1;
    private char[] line2;
    private char[] line3;
    private char[] line4;
    private char[] line5;
}
