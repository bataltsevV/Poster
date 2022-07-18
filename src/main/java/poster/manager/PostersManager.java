package poster.manager;

public class PostersManager {
    private String[] poster;
    private int qtyLastFilms;
    private int defaultQtyLastFilm = 10;


    public PostersManager() {
        this.qtyLastFilms = defaultQtyLastFilm;
    }

    public PostersManager(int newQtyLastFilm) {
        if (newQtyLastFilm > 0) {
            this.qtyLastFilms = newQtyLastFilm;
        } else {
            this.qtyLastFilms = defaultQtyLastFilm;
        }
    }

    public int getQtyLastFilms() {
        return qtyLastFilms;
    }

    public void addNewFilm(String filmsName) {
        String[] tmp;
        if (poster == null) {
            tmp = new String[1];
        } else {
            tmp = new String[poster.length + 1];
            for (int i = 0; i < poster.length; i++) {
                tmp[i] = poster[i];
            }
        }
        tmp[tmp.length - 1] = filmsName;
        poster = tmp;
    }

    public String[] findAll() {
        return poster;
    }

    public String[] findLast() {
        int resultLength;
        if (poster.length >= qtyLastFilms) {
            resultLength = qtyLastFilms;
        } else {
            resultLength = poster.length;
        }
        String[] result = new String[resultLength];
        int j = 0;
        for (int i = (poster.length - 1); i > (poster.length - 1 - resultLength); i--) {
            result[j] = poster[i];
            j = j + 1;
        }
        return result;
    }
}
