import com.google.gson.Gson;
import com.google.gson.JsonObject;
import entity.DataEvent;
import entity.DataEvent2;
import entity.Event;
import org.json.JSONException;
import org.json.JSONObject;

import javax.persistence.*;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

public class MainApplication {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
        EntityManager em = entityManagerFactory.createEntityManager();

        /*
        Persiste os dados

        EntityTransaction transaction = em.getTransaction();

        DataEvent2 dataEvent = new DataEvent2();
        dataEvent.setName("UFC party 2");
        dataEvent.setLocation("UFC QUIXADÁ");
        //dataEvent.setValue(1.00d);

        Event event = new Event<DataEvent2>();
        event.setDataEvent(dataEvent);

        try{
            transaction.begin();
            em.persist(event);
            transaction.commit();
        }catch (PersistenceException e){
            e.printStackTrace();
        } finally {
            em.close();
        }
        */

        /* Leitura de forma generica */
        Event event = em.find(Event.class, 1);
        String json = new Gson().toJson(event.getDataEvent());
        JSONObject object = new JSONObject(json);
        Iterator<String> keys = object.keys();

        try {

            while(keys.hasNext()) {
                String key = keys.next();
                System.out.println(object.get(key));
            }

        }catch (JSONException e){
            e.printStackTrace();
        }
    }
}