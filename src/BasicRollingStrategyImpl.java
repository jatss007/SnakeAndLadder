import java.util.List;

public class BasicRollingStrategyImpl implements DiceRollingStrategy{
    @Override
    public int getRolledValue(List<Dice> dices) {
        Integer finalRolledValue = dices.stream().map(dice -> dice.rollDice()).reduce(0, Integer::sum);
        return finalRolledValue;
    }
}
