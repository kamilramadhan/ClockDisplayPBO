public class Lagu {
    private String judul;
    private String artis;
    private String album;

    public Lagu(String judul, String artis, String album) {
        this.judul = judul;
        this.artis = artis;
        this.album = album;
    }

    public String getJudul() {
        return judul;
    }

    public String getArtis() {
        return artis;
    }

    public String getAlbum() {
        return album;
    }

    @Override
    public String toString() {
        return "Judul: " + judul + ", Artis: " + artis + ", Album: " + album;
    }
}
