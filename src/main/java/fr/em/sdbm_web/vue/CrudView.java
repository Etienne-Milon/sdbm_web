package fr.em.sdbm_web.vue;

import fr.em.sdbm_web.dao.ArticleDAO;
import fr.em.sdbm_web.dao.DaoFactory;
import fr.em.sdbm_web.metier.*;
import fr.em.sdbm_web.service.ArticleSearch;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.primefaces.PrimeFaces;

import java.io.Serializable;
import java.math.BigDecimal;

import java.util.List;

@Named
@ViewScoped
public class CrudView implements Serializable {
    private List<Article> articles;
    private Article selectedArticle;
    private List<Article> selectedArticles;
    private ArticleSearch articleSearch;
    private Double teneurMin = 0.0;
    private Double teneurMax = 50.0;
    private BigDecimal prixMin = new BigDecimal(0);
    private BigDecimal prixMax = new BigDecimal(10);
    private List<Couleur> allCouleur;
    private List<Marque> allMarques;
    private List <TypeBiere> allTypes;
    private List <Pays> allPays;
    private List <Continent> allContinents;
    private List <Fabricant> allFabricants;
    private Couleur selectedCouleur;
    private Marque selectedMarque;
    private TypeBiere selectedType;
    private Pays selectedPays;
    private Continent selectedContinent;
    private Fabricant selectedFabricant;

    @PostConstruct
    public void init(){
        articleSearch = new ArticleSearch();
        articleSearch.setLibelle("");
        this.articles = DaoFactory.getArticleDAO().getLike(articleSearch);
        this.teneurMin = articleSearch.getTitrageMin();
        this.teneurMax = articleSearch.getTitrageMax();
        this.prixMin = articleSearch.getPrixMin();
        this.prixMax = articleSearch.getPrixMax();
        this.allCouleur = DaoFactory.getCouleurDAO().getAll();
        this.allMarques = DaoFactory.getMarqueDAO().getAll();
        this.allTypes = DaoFactory.getTypeBiereDAO().getAll();
        this.allPays = DaoFactory.getPaysDAO().getAll();
        this.allContinents = DaoFactory.getContinentDAO().getAll();
        this.allFabricants = DaoFactory.getFabricantDAO().getAll();
    }

    public List<Article> getArticles() {
        return articles;
    }
    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public Article getSelectedArticle() {
        return selectedArticle;
    }

    public void setSelectedArticle(Article selectedArticle) {
        this.selectedArticle = selectedArticle;
    }

    public List<Article> getSelectedArticles() {
        return selectedArticles;
    }

    public void setSelectedArticles(List<Article> selectedArticles) {
        this.selectedArticles = selectedArticles;
    }

    public Double getTeneurMin() {
        return teneurMin;
    }

    public void setTeneurMin(Double teneurMin) {
        this.teneurMin = teneurMin;
    }

    public Double getTeneurMax() {
        return teneurMax;
    }

    public void setTeneurMax(Double teneurMax) {
        this.teneurMax = teneurMax;
    }

    public BigDecimal getPrixMin() {
        return prixMin;
    }

    public void setPrixMin(BigDecimal prixMin) {
        this.prixMin = prixMin;
    }

    public BigDecimal getPrixMax() {
        return prixMax;
    }

    public void setPrixMax(BigDecimal prixMax) {
        this.prixMax = prixMax;
    }

    public List<Couleur> getAllCouleur() {
        return allCouleur;
    }

    public void setAllCouleur(List<Couleur> allCouleur) {
        this.allCouleur = allCouleur;
    }

    public List<Marque> getAllMarques() {
        return allMarques;
    }

    public void setAllMarques(List<Marque> allMarques) {
        this.allMarques = allMarques;
    }

    public List<TypeBiere> getAllTypes() {
        return allTypes;
    }

    public void setAllTypes(List<TypeBiere> allTypes) {
        this.allTypes = allTypes;
    }

    public List<Pays> getAllPays() {
        return allPays;
    }

    public void setAllPays(List<Pays> allPays) {
        this.allPays = allPays;
    }

    public List<Continent> getAllContinents() {
        return allContinents;
    }

    public void setAllContinents(List<Continent> allContinents) {
        this.allContinents = allContinents;
    }

    public List<Fabricant> getAllFabricants() {
        return allFabricants;
    }

    public void setAllFabricants(List<Fabricant> allFabricants) {
        this.allFabricants = allFabricants;
    }

    public Couleur getSelectedCouleur() {
        return selectedCouleur;
    }

    public void setSelectedCouleur(Couleur selectedCouleur) {
        this.selectedCouleur = selectedCouleur;
    }

    public Marque getSelectedMarque() {
        return selectedMarque;
    }

    public void setSelectedMarque(Marque selectedMarque) {
        this.selectedMarque = selectedMarque;
    }

    public TypeBiere getSelectedType() {
        return selectedType;
    }

    public void setSelectedType(TypeBiere selectedType) {
        this.selectedType = selectedType;
    }

    public Pays getSelectedPays() {
        return selectedPays;
    }

    public void setSelectedPays(Pays selectedPays) {
        this.selectedPays = selectedPays;
    }

    public Continent getSelectedContinent() {
        return selectedContinent;
    }

    public void setSelectedContinent(Continent selectedContinent) {
        this.selectedContinent = selectedContinent;
    }

    public Fabricant getSelectedFabricant() {
        return selectedFabricant;
    }

    public void setSelectedFabricant(Fabricant selectedFabricant) {
        this.selectedFabricant = selectedFabricant;
    }





    public void openNew(){
        this.selectedArticle = new Article();
    }

    public void saveArticle(){
        if(this.selectedArticle.getId() == -1){
            DaoFactory.getArticleDAO().insert(selectedArticle);
            this.articles.add(selectedArticle);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Article ajouté"));
        }
        else{
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Produit mis à jour"));
        }
        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        PrimeFaces.current().ajax().update("from:messages","form:dt-products");
    }

    public void deleteArticle() {
        this.selectedArticles.remove(this.selectedArticle);
        DaoFactory.getArticleDAO().delete(selectedArticle);
        //articles = DaoFactory.getArticleDAO().getLike(articleSearch);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Article supprimé"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
        this.selectedArticle = null;
    }

    public String getDeleteButtonMessage() {
        if (hasSelectedProducts()) {
            int size = this.selectedArticles.size();
            return size > 1 ? size + " articles séléctionnés" : "1 article séléctionné";
        }
        return "Delete";
    }
    public boolean hasSelectedProducts() {
        return this.selectedArticles != null && !this.selectedArticles.isEmpty();
    }

    public void deleteSelectedProducts() {
        for (Article article : selectedArticles){
            DaoFactory.getArticleDAO().delete(article);
        }
        this.selectedArticle = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Articles supprimés"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
        PrimeFaces.current().executeScript("PF('dtProducts').clearFilters()");
    }

//    public void filtrer() {
//        articleSearch.setCouleur(selectedCouleur);
//        articleSearch.setPays(selectedPays);
//        articleSearch.setTypeBiere(selectedType);
//        articleSearch.setMarque(selectedMarque);
//        articleSearch.setFabricant(selectedFabricant);
//        articleSearch.setContinent(selectedContinent);
//        articles = DaoFactory.getArticleDAO().getLike(articleSearch);
//    }
}
