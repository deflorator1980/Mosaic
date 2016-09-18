package dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * Created by a on 18.09.16.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game {

    Character figure;

    Map<Integer, Integer> coordinates;
}
