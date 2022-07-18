package posters.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import poster.manager.PostersManager;

public class PostersManagerTests {
    @ParameterizedTest
    @CsvFileSource(resources = "/DataForTestPostersManagerWithoutVariable.csv")
    public void TestPostersManagerWithoutVariable(int expectedQtyLastFilm) {
        PostersManager postMag = new PostersManager();
        int actual = postMag.getQtyLastFilms();
        Assertions.assertEquals(actual, expectedQtyLastFilm);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/DataForTestPostersManagerWithVariable.csv")
    public void TestPostersManagerWthVariable(int expectedQtyLastFilm, int newQtyLastFilm) {
        PostersManager postMag = new PostersManager(newQtyLastFilm);
        int actual = postMag.getQtyLastFilms();
        Assertions.assertEquals(actual, expectedQtyLastFilm);
    }

    @Test
    public void TestAddNewFilmAndFindAll() {
        PostersManager postMag = new PostersManager();
        postMag.addNewFilm("Pirates");
        postMag.addNewFilm("Ghost");
        postMag.addNewFilm("DogsLife");
        postMag.addNewFilm("CatsLife");
        postMag.addNewFilm("Hobits");
        postMag.addNewFilm("Dragons");
        postMag.addNewFilm("Magic");
        postMag.addNewFilm("BeesLife");
        String[] expected = {
                "Pirates",
                "Ghost",
                "DogsLife",
                "CatsLife",
                "Hobits",
                "Dragons",
                "Magic",
                "BeesLife"
        };
        String[] actual = postMag.findAll();
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void TestFindLastQtyFilmsMoreThenNeed() {
        PostersManager postMag = new PostersManager(5);
        postMag.addNewFilm("Pirates");
        postMag.addNewFilm("Ghost");
        postMag.addNewFilm("DogsLife");
        postMag.addNewFilm("CatsLife");
        postMag.addNewFilm("Hobits");
        postMag.addNewFilm("Dragons");
        postMag.addNewFilm("Magic");
        postMag.addNewFilm("BeesLife");
        String[] expected = {
                "BeesLife",
                "Magic",
                "Dragons",
                "Hobits",
                "CatsLife",
        };
        String[] actual = postMag.findLast();
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void TestFindLastQtyFilmsBelowNeed() {
        PostersManager postMag = new PostersManager(5);
        postMag.addNewFilm("Hobits");
        postMag.addNewFilm("Dragons");
        postMag.addNewFilm("Magic");
        postMag.addNewFilm("BeesLife");
        String[] expected = {
                "BeesLife",
                "Magic",
                "Dragons",
                "Hobits",
        };
        String[] actual = postMag.findLast();
        Assertions.assertArrayEquals(actual, expected);
    }
}
