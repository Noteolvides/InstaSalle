package Comparators;

import JsonClasses.Post;
import JsonClasses.User;
import JsonClasses.UserConnections;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Feed implements Comparators<Post> {
    private class informationOfLlikeness{
        public informationOfLlikeness(String name, float getPercentajeTotal) {
            this.name = name;
            this.getPercentajeTotal = getPercentajeTotal;
        }
        private String name;
        private float getPercentajeTotal;

        @Override
        public String toString() {
            return "informationOfLlikeness{" +
                    "name='" + name + '\'' +
                    ", getPercentajeTotal=" + getPercentajeTotal +
                    '}';
        }
    }
    private List<UserConnections> connections;
    private User[] infomacionUsuarios;
    private List<Post> postsFeed = new ArrayList<Post>();
    private float[] howMuchIlikeAcategory = new float[11];
    private List<informationOfLlikeness> informationOfLlikenesses = new ArrayList<informationOfLlikeness>();
    private int user;


    public Feed(User[] infomacionUsuarios,int user) {
        this.user = user;
        this.connections = infomacionUsuarios[user].getConnections();
        this.infomacionUsuarios = infomacionUsuarios;
    }

    public List<Post> getInformation(){
        int a;
        int allLikes = 0;
        int allComments = 0;
        int allVisits = 0;
        List<Post> postsFeed = new ArrayList<Post>();

        //Por cada conexion con cada usuario guardamos el numero de likes que le ha dado el y el numero de comentarios.
        //Ademas ponemos una etiqueta a cada post para saber quien ha sido el creador del post, y los guardamos en un array que devolveremos.
        for (UserConnections i: connections) {
            String username = i.getUsername();
            a = Integer.parseInt(username.replace("user",""));
            allLikes += i.getLikes();
            allComments += i.getComments();
            allVisits += i.getVisits();
            List<Post> aux = infomacionUsuarios[a].getPosts();
            for (Post j: aux) {
                j.setCreator(username);
            }
            postsFeed.addAll(aux);
        }

        //Obtenemos un portcentaje de cuanto le gusta un usuario, para nosotros los likes y los comentarios valen lo mismo un 50%
        float howMuchILikeYou;
        for (UserConnections i:connections){
            howMuchILikeYou = (((float)i.getLikes()/allLikes + (float)i.getComments()/allComments)*100/2 + (float)i.getVisits()/allVisits*100)/2;
            informationOfLlikenesses.add(new informationOfLlikeness(i.getUsername(),howMuchILikeYou));
        }

        //Ahora obtenemos cuanto nos gusta una categoria
        for (Post i : postsFeed) {
            if (i.getLiked_by().contains(infomacionUsuarios[this.user].getUsername())){
                howMuchIlikeAcategory[i.getCategory()] += 1.0;
            }
        }

        System.out.println("categorias");
        //Obtenemos el porcentaje
        for (int i = 0; i < howMuchIlikeAcategory.length; i++) {
            howMuchIlikeAcategory[i] = (howMuchIlikeAcategory[i]*100)/allLikes;
        }

        //Por fin obetenemos cuanto nos gusta una persona
        for (Post i:postsFeed) {
            float llikenessOfUser = 0;
            for (informationOfLlikeness j : informationOfLlikenesses) {
                if(j.name.equals(i.getCreator())){
                    llikenessOfUser = j.getPercentajeTotal;
                    break;
                }
            }
            i.setNewPublised((int) (howMuchIlikeAcategory[i.getCategory()]*60*60*12) + (int)(llikenessOfUser*60*60*12) + i.getPublished());
        }
        return postsFeed;
    }


    public int compare(Post o1, Post o2) {
        return o2.getNewPublised().compareTo(o1.getNewPublised());
    }

    public int getValue(Post o1) {
        return o1.getNewPublised();
    }
}
