package fr.em.sdbm_web.metier;


public class Marque
{

    private int id;
    private String libelle;
    private Pays pays;
    private Fabricant fabricant;
    private  Continent continent;

    public Marque(){
       pays = new Pays();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Pays getPays()
    {
	return pays;
    }

    public void setPays(Pays pays)
    {
	this.pays = pays;
    }

    public Fabricant getFabricant()
    {
	return fabricant;
    }

    public void setFabricant(Fabricant fabricant)
    {
	this.fabricant = fabricant;
    }

    @Override
    public String toString()
    {
	return libelle;
    }


    public Continent getContinent() {return continent;}

}
