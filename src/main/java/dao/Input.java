package dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by a on 19.09.16.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Input {
    List<Figure> tetrominos;
}
