import javax.management.BadAttributeValueExpException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class Machine {
    private final Random random = new Random();
    private final PriorityQueue<Toy> queue = new PriorityQueue<>();
    private final List<Toy> winnings = new ArrayList<>();
    private Boolean staffed = false;
    public void addToQueue(Toy t) throws Exception {
        if(id_exists(t.id)) {
            throw new Exception("ID already in queue. ");
        } else {
            staffed = false;
            queue.add(t);
        }
    }

    public void staff(int count) throws Exception {
        int result = 0;

        for(Toy toy : queue) {
            result += toy.chance;
        }
        if(result%10!=0) {
            throw new Exception("Invalid chances given. ");
        } else {
            List<Toy> chances = new ArrayList<>();
            for(Toy toy : queue) {
                 for(int j = 0; j < toy.chance; j++) {
                     chances.add(toy);
                 }
            }

            for(int i = 0; i < count; i++) {
                winnings.add(chances.get(random.nextInt(result)));
            }
        }
        staffed = true;
    }

    public List<Toy> get_winnings() throws Exception{
        if(staffed) return winnings;
        else throw new Exception("List is not staffed. ");
    }

    public boolean id_exists(int id) {
        for(Toy toy : queue) {
            if(toy.id == id) return true;
        }
        return false;
    }
}
