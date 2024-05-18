import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEvento {
    private Map<LocalDate,Evento> eventos;

    public AgendaEvento() {
        this.eventos = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao){
        Evento evento = new Evento(nome, atracao);
        eventos.put(data, evento);
    }

    public void exibirAgenda(){
        Map<LocalDate,Evento> eventosTreeMap = new TreeMap<>(eventos);
    }

    public void obterProximoEvento(){
        LocalDate dataAtual = LocalDate.now();

        for(Map.Entry<LocalDate, Evento> entry: eventos.entrySet()){
            if(entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)){
                System.out.println("O proximo evento " + entry.getValue() + " acontecera na data " + entry.getKey());
                break;
            }
        }
    }
}
