package com.autoclinic.UTILS;

import android.content.Context;
import android.graphics.AvoidXfermode;

import com.autoclinic.MODEL.ModeleImage;
import com.autoclinic.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by SEYDOU BERTHE on 04/05/2016.
 */
public class Entry {

    //PROJECT REQUEST PATH
    public static final String LISTE_ASSURANCE = "/Assurance/listAssurance";
    public static final String CREATE_ASSURANCE = "/Assurance/saveAssurance";
    public static final String LISTE_FICHE = "/fiche/list/{assurancename}/{etat}";
    public static final String ADD_FICHE = "/fiche/add/{assurance}/{fiche}";
    public static final String ADD_FICHE_V3 = "/fiche/save2/{Assurancename}/{fichename}/{immatriculation}/{marque}/{Modele}/{NumChassais}/{kilometrage}/{nivcarburant}/{Receptionle}/{noms}/{Adresse}/{telbureau}/{telMobile}/{fax}/{nomuser}/{tel}";

    static final String vehP = "{marque}/{modele}/{immatriculation}/{NumChassais}/{kilometrage}/{nivcarburant}";
    static final String clientP = "/{nom}/{address}/{email}/{mobile}/{tel}/{fax}/";
    public static final String ADD_FICHE_V2 = "/fiche/addV2/{assurance}/{fiche}"+clientP+vehP;

    public static final String FICHE_FRAGMENT_TYPE = "fiche_frag";
    public static final String FORM_FRAGMENT_TYPE = "form_frag";
    public static final String ADD_FRAG_FICHE = "add_fhi";
    public static final String[] NIVEAU_CARB = new String[]{"0", "1/4", "2/3", "1/2", "1"};
    public static final String SEPARATOR = "|";
    public static final String FILE = "mock.txt";
    public static final String PLACEHOLDER = "Unknown";
    public static final String TYPE_GRID = "grid";
    public static final String TYPE_LIST = "list";

    public static final ArrayList<ModeleImage> getModelWithMarque(Context context, String marque){
        ArrayList<ModeleImage> modeles = new ArrayList<ModeleImage>();
        String[] names ;
        int[] images;
        switch (marque){
            case "Audi":
                images = new int[]{
                        R.drawable.a4,
                        R.drawable.a3,
                        R.drawable.a6,
                        R.drawable.a80,
                        R.drawable.tt,
                        R.drawable.a100,
                        R.drawable.cabriolet,
                        R.drawable.a8,
                        R.drawable.allroad,
                        R.drawable.a2,
                        R.drawable.a5,
                        R.drawable.quattro,
                        R.drawable.q7,
                        R.drawable.r8,
                        R.drawable.v8,
                        R.drawable.a90,
                        R.drawable.a200,
                        R.drawable.q5,
                        R.drawable.q3,
                        R.drawable.a1,
                        R.drawable.a7
                };

            names = context.getResources().getStringArray(R.array.Audi);
                for (int i=0; i<names.length; i++){
                    ModeleImage tmp = new ModeleImage();
                    tmp.setResID(images[i]);
                    tmp.setName(names[i]);
                    modeles.add(tmp);
                }

                return modeles;

            case "Bmw" :

                images = new int[]{
                        R.drawable.x6,
                        R.drawable.x5,
                        R.drawable.x3,
                        R.drawable.z8,
                        R.drawable.z4,
                        R.drawable.z3,
                        R.drawable.z1,
                        R.drawable.b8e31,
                        R.drawable.x1,
                        R.drawable.x4
                };

                names = context.getResources().getStringArray(R.array.Bmw);
                for (int i=0; i<names.length; i++){
                    ModeleImage tmp = new ModeleImage();
                    tmp.setResID(images[i]);
                    tmp.setName(names[i]);
                    modeles.add(tmp);
                }

                return modeles;

            case "Cadilac" :

                images =  new int[]{
                        R.drawable.srx,
                        R.drawable.bls,
                        R.drawable.cts,
                        R.drawable.escalade,
                        R.drawable.eldorado,
                        R.drawable.sts,
                        R.drawable.xlr,
                        R.drawable.ats
                };

                names = context.getResources().getStringArray(R.array.Cadilac);
                for (int i=0; i<names.length; i++){
                    ModeleImage tmp = new ModeleImage();
                    tmp.setResID(images[i]);
                    tmp.setName(names[i]);
                    modeles.add(tmp);
                }

                return modeles;

            case "Chevrolet" :

                images = new int[]{
                        R.drawable.corvette,
                        R.drawable.nubira,
                        R.drawable.kalos,
                        R.drawable.matiz,
                        R.drawable.aveo,
                        R.drawable.lacetti,
                        R.drawable.epica,
                        R.drawable.captiva,
                        R.drawable.cruze,
                        R.drawable.spark,
                        R.drawable.orlando,
                        R.drawable.volt,
                        R.drawable.camaro,
                        R.drawable.agile,
                        R.drawable.malibu,
                        R.drawable.trax
                };

                names = context.getResources().getStringArray(R.array.Chevrolet);
                for (int i=0; i<names.length; i++){
                    ModeleImage tmp = new ModeleImage();
                    tmp.setResID(images[i]);
                    tmp.setName(names[i]);
                    modeles.add(tmp);
                }

                return modeles;

            case "Chrysler" :

                images =  new int[]{
                        R.drawable.voyager,
                        R.drawable.ptcruiser,
                        R.drawable.c300,
                        R.drawable.neon,
                        R.drawable.vision,
                        R.drawable.viper,
                };

                names = context.getResources().getStringArray(R.array.Chrysler);
                for (int i=0; i<names.length; i++){
                    ModeleImage tmp = new ModeleImage();
                    tmp.setResID(images[i]);
                    tmp.setName(names[i]);
                    modeles.add(tmp);
                }

                return modeles;

            case "Citroen" :

                images =  new int[]{
                        R.drawable.xsara,
                        R.drawable.c4,
                        R.drawable.c3,
                        R.drawable.c5,
                        R.drawable.xantia,
                        R.drawable.berlingo,
                        R.drawable.saxo,
                        R.drawable.zx,
                        R.drawable.ax,
                        R.drawable.cv,
                        R.drawable.c15,
                        R.drawable.xm,
                        R.drawable.c2,
                        R.drawable.jumpy,
                        R.drawable.bx,
                        R.drawable.c8,
                        R.drawable.cx,
                        R.drawable.c1,
                        R.drawable.relay,
                        R.drawable.ccrosser,
                        R.drawable.c6,
                        R.drawable.ds3,
                        R.drawable.ds4,
                        R.drawable.ds5,
                        R.drawable.nemo
                };

                names = context.getResources().getStringArray(R.array.Citroen);
                for (int i=0; i<names.length; i++){
                    ModeleImage tmp = new ModeleImage();
                    tmp.setResID(images[i]);
                    tmp.setName(names[i]);
                    modeles.add(tmp);
                }

                return modeles;

            case "Dacia" :

                images =  new int[]{
                        R.drawable.logan,
                        R.drawable.solenza,
                        R.drawable.sandero,
                        R.drawable.duster,
                        R.drawable.lodgy,
                        R.drawable.dokker,
                };

                names = context.getResources().getStringArray(R.array.Dacia);
                for (int i=0; i<names.length; i++){
                    ModeleImage tmp = new ModeleImage();
                    tmp.setResID(images[i]);
                    tmp.setName(names[i]);
                    modeles.add(tmp);
                }

                return modeles;

            case "Daewoo" :

                images = new int[]{
                        R.drawable.nexia,
                        R.drawable.nubira,
                        R.drawable.matiz,
                        R.drawable.leganza,
                        R.drawable.espero,
                        R.drawable.kalos,
                        R.drawable.korando,
                        R.drawable.lanos,
                        R.drawable.musso,
                        R.drawable.evanda,
                        R.drawable.lacetti,
                        R.drawable.lublin,
                        R.drawable.rexton,
                        R.drawable.tacuma,
                        R.drawable.tico
                };

                names = context.getResources().getStringArray(R.array.Daewoo);
                for (int i=0; i<names.length; i++){
                    ModeleImage tmp = new ModeleImage();
                    tmp.setResID(images[i]);
                    tmp.setName(names[i]);
                    modeles.add(tmp);
                }

                return modeles;

            case "Daihatsu" :

                images =  new int[]{
                        R.drawable.sirion,
                        R.drawable.materia,
                        R.drawable.cuore,
                        R.drawable.terios,
                        R.drawable.sportrak,
                        R.drawable.rocky,
                        R.drawable.trevis,
                        R.drawable.yrv,
                        R.drawable.move,
                        R.drawable.copen,
                        R.drawable.hijet,
                        R.drawable.charade,
                        R.drawable.applause,
                        R.drawable.granmove,
                        R.drawable.sparcar,
                        R.drawable.taft,
                        R.drawable.valeraiv,
                        R.drawable.wildcat_rocky,
                        R.drawable.charmant,
                        R.drawable.mira,
                        R.drawable.extol
                };

                names = context.getResources().getStringArray(R.array.Daihatsu);
                for (int i=0; i<names.length; i++){
                    ModeleImage tmp = new ModeleImage();
                    tmp.setResID(images[i]);
                    tmp.setName(names[i]);
                    modeles.add(tmp);
                }

                return modeles;

            case "Dodge" :

                images =  new int[]{
                        R.drawable.caliber,
                        R.drawable.avenger,
                        R.drawable.caravan,
                        R.drawable.viper,
                        R.drawable.stratus,
                        R.drawable.neon,
                        R.drawable.charger,
                        R.drawable.challenger,
                        R.drawable.trazo,
                        R.drawable.durango,
                        R.drawable.h100,
                        R.drawable.attitude,
                        R.drawable.i10,
                        R.drawable.atos,
                        R.drawable.journey
                };

                names = context.getResources().getStringArray(R.array.Dodge);
                for (int i=0; i<names.length; i++){
                    ModeleImage tmp = new ModeleImage();
                    tmp.setResID(images[i]);
                    tmp.setName(names[i]);
                    modeles.add(tmp);
                }

                return modeles;

            case "Ferrari" :

                images =  new int[]{
                        R.drawable.f348,
                        R.drawable.f328,
                        R.drawable.f355,
                        R.drawable.f360modena,
                        R.drawable.f512,
                        R.drawable.f456gt,
                        R.drawable.f599gtbfiorano,
                        R.drawable.f612scaglietti,
                        R.drawable.f5maranello,
                        R.drawable.enzoferrari,
                        R.drawable.f550barchetta,
                        R.drawable.california,
                        R.drawable.f458,
                        R.drawable.ff,
                        R.drawable.f12berlinetta
                };

                names = context.getResources().getStringArray(R.array.Ferrari);
                for (int i=0; i<names.length; i++){
                    ModeleImage tmp = new ModeleImage();
                    tmp.setResID(images[i]);
                    tmp.setName(names[i]);
                    modeles.add(tmp);
                }

                return modeles;

            case "Fiat" :

                images =  new int[]{
                        R.drawable.punto,
                        R.drawable.ducato,
                        R.drawable.panda,
                        R.drawable.stilo,
                        R.drawable.grandepunto,
                        R.drawable.brava,
                        R.drawable.doblo,
                        R.drawable.multipla,
                        R.drawable.fi500,
                        R.drawable.ulysse,
                        R.drawable.seicento,
                        R.drawable.scudo,
                        R.drawable.cinquecento,
                        R.drawable.palio,
                        R.drawable.uno,
                        R.drawable.marea,
                        R.drawable.tipo,
                        R.drawable.coupe,
                        R.drawable.croma,
                        R.drawable.siena,
                        R.drawable.fi124,
                        R.drawable.fiorino,
                        R.drawable.tempra,
                        R.drawable.barchetta,
                        R.drawable.x19,
                        R.drawable.idea,
                        R.drawable.sedici,
                        R.drawable.fi126,
                        R.drawable.fi600,
                        R.drawable.fi850,
                        R.drawable.fi128,
                        R.drawable.fi15002300,
                        R.drawable.fi125,
                        R.drawable.fi127,
                        R.drawable.ritmo,
                        R.drawable.fi135,
                        R.drawable.argenta,
                        R.drawable.strada,
                        R.drawable.talento,
                        R.drawable.fi130,
                        R.drawable.jagst,
                        R.drawable.linea,
                        R.drawable.premio,
                        R.drawable.fi131,
                        R.drawable.fi132,
                        R.drawable.fi147,
                        R.drawable.campagnola,
                        R.drawable.duna,
                        R.drawable.elba,
                        R.drawable.regata,
                        R.drawable.qubo,
                        R.drawable.freemont,
                        R.drawable.bravo,
                        R.drawable.puntoevo
                };

                names = context.getResources().getStringArray(R.array.Fiat);
                for (int i=0; i<names.length; i++){
                    ModeleImage tmp = new ModeleImage();
                    tmp.setResID(images[i]);
                    tmp.setName(names[i]);
                    modeles.add(tmp);
                }

                return modeles;

            case "Ford" :

                images =  new int[]{
                        R.drawable.fiesta,
                        R.drawable.focus,
                        R.drawable.mondeo,
                        R.drawable.escort,
                        R.drawable.transit,
                        R.drawable.cmax,
                        R.drawable.ka,
                        R.drawable.galaxy,
                        R.drawable.fusion,
                        R.drawable.smax,
                        R.drawable.tourneoconnect,
                        R.drawable.ranger,
                        R.drawable.scorpio,
                        R.drawable.sierra,
                        R.drawable.maverick,
                        R.drawable.gt,
                        R.drawable.cougar,
                        R.drawable.orion,
                        R.drawable.kuga,
                        R.drawable.courier,
                        R.drawable.ecosport,
                        R.drawable.bmax
                };

                names = context.getResources().getStringArray(R.array.Ford);
                for (int i=0; i<names.length; i++){
                    ModeleImage tmp = new ModeleImage();
                    tmp.setResID(images[i]);
                    tmp.setName(names[i]);
                    modeles.add(tmp);
                }

                return modeles;

            case "Honda" :

                images =  new int[]{
                        R.drawable.civic,
                        R.drawable.accord,
                        R.drawable.crv,
                        R.drawable.crx,
                        R.drawable.prelude,
                        R.drawable.jazz,
                        R.drawable.s2000,
                        R.drawable.concerto,
                        R.drawable.frv,
                        R.drawable.hrv,
                        R.drawable.integra,
                        R.drawable.logo,
                        R.drawable.insight,
                        R.drawable.shuttle,
                        R.drawable.legend,
                        R.drawable.stream,
                        R.drawable.nsx,
                        R.drawable.actytn,
                        R.drawable.quintet,
                        R.drawable.capa,
                        R.drawable.niii,
                        R.drawable.airwave,
                        R.drawable.city,
                        R.drawable.element,
                        R.drawable.stepwagon,
                        R.drawable.odyssey,
                        R.drawable.pilot,
                        R.drawable.mdx,
                        R.drawable.crz,
                        R.drawable.crosstour,
                };

                names = context.getResources().getStringArray(R.array.Honda);
                for (int i=0; i<names.length; i++){
                    ModeleImage tmp = new ModeleImage();
                    tmp.setResID(images[i]);
                    tmp.setName(names[i]);
                    modeles.add(tmp);
                }

                return modeles;

            case "Hyundai" :

                images =  new int[]{
                        R.drawable.santa,
                        R.drawable.accent,
                        R.drawable.getz,
                        R.drawable.coupe,
                        R.drawable.tucson,
                        R.drawable.i30,
                        R.drawable.matrix,
                        R.drawable.galloper,
                        R.drawable.atos,
                        R.drawable.trajet,
                        R.drawable.terracan,
                        R.drawable.lantra,
                        R.drawable.pony,
                        R.drawable.sonata,
                        R.drawable.elantra,
                        R.drawable.excel,
                        R.drawable.h100,
                        R.drawable.h1camionnette,
                        R.drawable.starex,
                        R.drawable.xg,
                        R.drawable.grandeur,
                        R.drawable.santamo,
                        R.drawable.stellar,
                        R.drawable.i10,
                        R.drawable.i20,
                        R.drawable.ix55,
                        R.drawable.ix35,
                        R.drawable.ix20,
                        R.drawable.genesis,
                        R.drawable.i40
                };

                names = context.getResources().getStringArray(R.array.Hyundai);
                for (int i=0; i<names.length; i++){
                    ModeleImage tmp = new ModeleImage();
                    tmp.setResID(images[i]);
                    tmp.setName(names[i]);
                    modeles.add(tmp);
                }

                return modeles;

            case "Isuzu" :

                images = new int[]{
                        R.drawable.dmax,
                        R.drawable.trooper,
                        R.drawable.faster,
                        R.drawable.midi,
                        R.drawable.ascender,
                        R.drawable.gemini,
                        R.drawable.impulse,
                        R.drawable.piazza
                };

                names = context.getResources().getStringArray(R.array.Isuzi);
                for (int i=0; i<names.length; i++){
                    ModeleImage tmp = new ModeleImage();
                    tmp.setResID(images[i]);
                    tmp.setName(names[i]);
                    modeles.add(tmp);
                }

                return modeles;

            case "Jaguar" :

                images =  new int[]{
                        R.drawable.xtype,
                        R.drawable.stype,
                        R.drawable.xj,
                        R.drawable.xk,
                        R.drawable.xf,
                        R.drawable.ftype
                };

                names = context.getResources().getStringArray(R.array.Jaguar);
                for (int i=0; i<names.length; i++){
                    ModeleImage tmp = new ModeleImage();
                    tmp.setResID(images[i]);
                    tmp.setName(names[i]);
                    modeles.add(tmp);
                }

                return modeles;

            case "Jeep" :

                images = new int[]{
                        R.drawable.grandcherokee,
                        R.drawable.cherokee,
                        R.drawable.wrangler,
                        R.drawable.cj5cj8,
                        R.drawable.compass,
                        R.drawable.commander,
                };

                names = context.getResources().getStringArray(R.array.Jeep);
                for (int i=0; i<names.length; i++){
                    ModeleImage tmp = new ModeleImage();
                    tmp.setResID(images[i]);
                    tmp.setName(names[i]);
                    modeles.add(tmp);
                }

                return modeles;

            case "Kia" :

                images = new int[]{
                        R.drawable.picanto,
                        R.drawable.sportage,
                        R.drawable.carens,
                        R.drawable.ceed,
                        R.drawable.sorento,
                        R.drawable.rio,
                        R.drawable.sedona,
                        R.drawable.cerato,
                        R.drawable.shuma,
                        R.drawable.pride,
                        R.drawable.clarus,
                        R.drawable.magentis,
                        R.drawable.sephia,
                        R.drawable.opirus,
                        R.drawable.roadster,
                        R.drawable.joice,
                        R.drawable.retona,
                        R.drawable.soul,
                        R.drawable.venga,
                        R.drawable.optima,
                        R.drawable.cadenza
                };

                names = context.getResources().getStringArray(R.array.Kia);
                for (int i=0; i<names.length; i++){
                    ModeleImage tmp = new ModeleImage();
                    tmp.setResID(images[i]);
                    tmp.setName(names[i]);
                    modeles.add(tmp);
                }

                return modeles;

            case "Lamborghini" :


                images = new int[]{
                        R.drawable.gallardo,
                        R.drawable.diablo
                };
                names = context.getResources().getStringArray(R.array.Lamborghini);
                for (int i=0; i<names.length; i++){
                    ModeleImage tmp = new ModeleImage();
                    tmp.setResID(images[i]);
                    tmp.setName(names[i]);
                    modeles.add(tmp);
                }

                return modeles;

            case "Lancia" :

                images = new int[]{
                        R.drawable.delta,
                        R.drawable.musa,
                        R.drawable.ypsilon,
                        R.drawable.lybra,
                        R.drawable.dedra,
                        R.drawable.y,
                        R.drawable.phedra,
                        R.drawable.kappa,
                        R.drawable.zeta,
                        R.drawable.thema,
                        R.drawable.thesis,
                        R.drawable.prisma,
                        R.drawable.voyager,
                        R.drawable.flavia
                };

                names = context.getResources().getStringArray(R.array.Lancia);
                for (int i=0; i<names.length; i++){
                    ModeleImage tmp = new ModeleImage();
                    tmp.setResID(images[i]);
                    tmp.setName(names[i]);
                    modeles.add(tmp);
                }

                return modeles;

            case "Lexus" :

                images = new int[]{
                        R.drawable.is,
                        R.drawable.rx,
                        R.drawable.gs,
                        R.drawable.ls,
                        R.drawable.es,
                        R.drawable.sc,
                        R.drawable.ct,
                        R.drawable.lx,
                        R.drawable.gx,
                };

                names = context.getResources().getStringArray(R.array.Lexus);
                for (int i=0; i<names.length; i++){
                    ModeleImage tmp = new ModeleImage();
                    tmp.setResID(images[i]);
                    tmp.setName(names[i]);
                    modeles.add(tmp);
                }

                return modeles;

            case "Mazda" :

                images = new int[]{
                        R.drawable.ma323,
                        R.drawable.ma6,
                        R.drawable.mx,
                        R.drawable.ma3,
                        R.drawable.ma626,
                        R.drawable.ma2,
                        R.drawable.ma5,
                        R.drawable.premacy,
                        R.drawable.mpv,
                        R.drawable.bserie,
                        R.drawable.demio,
                        R.drawable.m121,
                        R.drawable.bt50,
                        R.drawable.rx,
                        R.drawable.ma929,
                        R.drawable.tribute,
                        R.drawable.cx-7,
                        R.drawable.xedos,
                        R.drawable.cx-9,
                        R.drawable.cx-5
                };

                names = context.getResources().getStringArray(R.array.Mazda);
                for (int i=0; i<names.length; i++){
                    ModeleImage tmp = new ModeleImage();
                    tmp.setResID(images[i]);
                    tmp.setName(names[i]);
                    modeles.add(tmp);
                }

                return modeles;

            case "Mercedes_Benz" :

                images = new int[]{
                        R.drawable.classec,
                        R.drawable.classee,
                        R.drawable.classea,
                        R.drawable.vito,
                        R.drawable.classem,
                        R.drawable.sprinter,
                        R.drawable.atroisvolumes,
                        R.drawable.clk,
                        R.drawable.classes,
                        R.drawable.me190,
                        R.drawable.classeb,
                        R.drawable.slk,
                        R.drawable.classeg,
                        R.drawable.classev,
                        R.drawable.sl,
                        R.drawable.viano,
                        R.drawable.kombi,
                        R.drawable.t2_l,
                        R.drawable.coupe,
                        R.drawable.t1autobus_autocar,
                        R.drawable.vaneo,
                        R.drawable.cabriolet,
                        R.drawable.vario,
                        R.drawable.me100,
                        R.drawable.cls,
                        R.drawable.classegl,
                        R.drawable.classer,
                        R.drawable.slr,
                        R.drawable.classeclc,
                        R.drawable.classeglk,
                        R.drawable.slsamg,
                        R.drawable.citan,
                        R.drawable.cla
                };

                names = context.getResources().getStringArray(R.array.Mercedes_Benz);
                for (int i=0; i<names.length; i++){
                    ModeleImage tmp = new ModeleImage();
                    tmp.setResID(images[i]);
                    tmp.setName(names[i]);
                    modeles.add(tmp);
                }

                return modeles;

            case "MG" :

                images = new int[]{
                        R.drawable.mgf,
                        R.drawable.mgb,
                        R.drawable.mg,
                        R.drawable.midget,
                        R.drawable.mgc,
                        R.drawable.mg1300mkii,
                        R.drawable.maestro,
                        R.drawable.mgr,
                        R.drawable.montego,
                        R.drawable.magnette,
                        R.drawable.metro
                };

                names = context.getResources().getStringArray(R.array.MG);
                for (int i=0; i<names.length; i++){
                    ModeleImage tmp = new ModeleImage();
                    tmp.setResID(images[i]);
                    tmp.setName(names[i]);
                    modeles.add(tmp);
                }

                return modeles;

            case "Mini" :

                images = new int[]{
                        R.drawable.mini,
                        R.drawable.minicountryman,
                        R.drawable.miniclubvan,
                        R.drawable.minipaceman
                };

                names = context.getResources().getStringArray(R.array.Mini);
                for (int i=0; i<names.length; i++){
                    ModeleImage tmp = new ModeleImage();
                    tmp.setResID(images[i]);
                    tmp.setName(names[i]);
                    modeles.add(tmp);
                }

                return modeles;

            case "Mitsubishi" :

                images = new int[]{
                        R.drawable.l200,
                        R.drawable.colt,
                        R.drawable.spacestar,
                        R.drawable.pajerosport,
                        R.drawable.carisma,
                        R.drawable.outlander,
                        R.drawable.lancer,
                        R.drawable.spacewagon,
                        R.drawable.galant,
                        R.drawable.galloper,
                        R.drawable.grandis,
                        R.drawable.shogun,
                        R.drawable.spacerunner,
                        R.drawable.mi3000gt,
                        R.drawable.l400,
                        R.drawable.eclipse,
                        R.drawable.celeste,
                        R.drawable.l300,
                        R.drawable.santamo,
                        R.drawable.sapporo,
                        R.drawable.starion,
                        R.drawable.sigma,
                        R.drawable.cordia,
                        R.drawable.proudia_dignity,
                        R.drawable.tredia,
                        R.drawable.asx,
                        R.drawable.delica
                };

                names = context.getResources().getStringArray(R.array.Mitsubishi);
                for (int i=0; i<names.length; i++){
                    ModeleImage tmp = new ModeleImage();
                    tmp.setResID(images[i]);
                    tmp.setName(names[i]);
                    modeles.add(tmp);
                }

                return modeles;

            case "Nissan" :

                images = new int[]{
                        R.drawable.micra,
                        R.drawable.primera,
                        R.drawable.almera,
                        R.drawable.xtrail,
                        R.drawable.qashqai,
                        R.drawable.patrol,
                        R.drawable.terrano,
                        R.drawable.pickup,
                        R.drawable.pathfinder,
                        R.drawable.sunny,
                        R.drawable.navara,
                        R.drawable.note,
                        R.drawable.vanette,
                        R.drawable.serena,
                        R.drawable.datsun,
                        R.drawable.murano,
                        R.drawable.n300zx,
                        R.drawable.n200sx,
                        R.drawable.n280zxzxt,
                        R.drawable.maxima,
                        R.drawable.silvia,
                        R.drawable.prairie,
                        R.drawable.urvan,
                        R.drawable.n100nx,
                        R.drawable.n350z,
                        R.drawable.primastar,
                        R.drawable.tiida,
                        R.drawable.bluebird,
                        R.drawable.cherry,
                        R.drawable.kubistar,
                        R.drawable.stanza,
                        R.drawable.interstar,
                        R.drawable.laurel,
                        R.drawable.gtr,
                        R.drawable.n370z,
                        R.drawable.teana,
                        R.drawable.nv200,
                        R.drawable.juke,
                        R.drawable.leaf,
                        R.drawable.pixo,
                        R.drawable.sentra
                };

                names = context.getResources().getStringArray(R.array.Nissan);
                for (int i=0; i<names.length; i++){
                    ModeleImage tmp = new ModeleImage();
                    tmp.setResID(images[i]);
                    tmp.setName(names[i]);
                    modeles.add(tmp);
                }

                return modeles;

            case "Opel" :

                images = new int[]{
                        R.drawable.astra,
                        R.drawable.corsa,
                        R.drawable.vectra,
                        R.drawable.zafira,
                        R.drawable.omega,
                        R.drawable.meriva,
                        R.drawable.frontera,
                        R.drawable.kadett,
                        R.drawable.signum,
                        R.drawable.agila,
                        R.drawable.calibraa,
                        R.drawable.vivaro,
                        R.drawable.tigra,
                        R.drawable.antara,
                        R.drawable.ascona,
                        R.drawable.sintra,
                        R.drawable.combo,
                        R.drawable.manta,
                        R.drawable.campo,
                        R.drawable.gt,
                        R.drawable.movano,
                        R.drawable.commodore,
                        R.drawable.senator,
                        R.drawable.admiral,
                        R.drawable.monza,
                        R.drawable.olympia,
                        R.drawable.rekord,
                        R.drawable.speedster,
                        R.drawable.arena,
                        R.drawable.diplomat,
                        R.drawable.monterey,
                        R.drawable.insignia,
                        R.drawable.mokka,
                        R.drawable.adam,
                        R.drawable.cascada
                };

                names = context.getResources().getStringArray(R.array.Opel);
                for (int i=0; i<names.length; i++){
                    ModeleImage tmp = new ModeleImage();
                    tmp.setResID(images[i]);
                    tmp.setName(names[i]);
                    modeles.add(tmp);
                }

                return modeles;

            case "Peugeot" :

                images = new int[]{
                        R.drawable.p206,
                        R.drawable.p307,
                        R.drawable.p306,
                        R.drawable.p207,
                        R.drawable.p205,
                        R.drawable.p406,
                        R.drawable.p106,
                        R.drawable.p407,
                        R.drawable.partner,
                        R.drawable.p308,
                        R.drawable.p405,
                        R.drawable.p607,
                        R.drawable.p806,
                        R.drawable.p807,
                        R.drawable.boxer,
                        R.drawable.p309,
                        R.drawable.expert,
                        R.drawable.p504,
                        R.drawable.p605,
                        R.drawable.p404,
                        R.drawable.p107,
                        R.drawable.j5,
                        R.drawable.p505,
                        R.drawable.p304,
                        R.drawable.p204,
                        R.drawable.p20coeur,
                        R.drawable.p305,
                        R.drawable.j9,
                        R.drawable.p1007,
                        R.drawable.p104,
                        R.drawable.p4007,
                        R.drawable.p604,
                        R.drawable.j7,
                        R.drawable.bipper,
                        R.drawable.p3008,
                        R.drawable.p5008,
                        R.drawable.rcz,
                        R.drawable.p508,
                        R.drawable.p408,
                        R.drawable.p208,
                        R.drawable.p4008,
                        R.drawable.p301,
                        R.drawable.p2008,
                        R.drawable.hoggar
                };

                names = context.getResources().getStringArray(R.array.Peugeot);
                for (int i=0; i<names.length; i++){
                    ModeleImage tmp = new ModeleImage();
                    tmp.setResID(images[i]);
                    tmp.setName(names[i]);
                    modeles.add(tmp);
                }

                return modeles;

            case "Porsche" :

                images = new int[]{
                        R.drawable.po911,
                        R.drawable.cayenne,
                        R.drawable.boxster,
                        R.drawable.po944,
                        R.drawable.po924,
                        R.drawable.po356,
                        R.drawable.cayman,
                        R.drawable.po912,
                        R.drawable.po914,
                        R.drawable.po968,
                        R.drawable.carreragt,
                        R.drawable.po928,
                        R.drawable.po959,
                        R.drawable.panamera,
                        R.drawable.macan
                };

                names = context.getResources().getStringArray(R.array.Porsche);
                for (int i=0; i<names.length; i++){
                    ModeleImage tmp = new ModeleImage();
                    tmp.setResID(images[i]);
                    tmp.setName(names[i]);
                    modeles.add(tmp);
                }

                return modeles;

            case "Renault" :

                images = new int[]{
                        R.drawable.clio,
                        R.drawable.laguna,
                        R.drawable.megane,
                        R.drawable.espace,
                        R.drawable.twingo,
                        R.drawable.kangoo,
                        R.drawable.trafic,
                        R.drawable.r19,
                        R.drawable.master,
                        R.drawable.safrane,
                        R.drawable.r4,
                        R.drawable.modus,
                        R.drawable.super5,
                        R.drawable.r21,
                        R.drawable.r5,
                        R.drawable.rapidkasten,
                        R.drawable.r8,
                        R.drawable.velsatis,
                        R.drawable.r25,
                        R.drawable.r11,
                        R.drawable.r12,
                        R.drawable.r16,
                        R.drawable.rodeo,
                        R.drawable.r18,
                        R.drawable.r9,
                        R.drawable.r10,
                        R.drawable.fuego,
                        R.drawable.r30,
                        R.drawable.r6,
                        R.drawable.r17,
                        R.drawable.thalia,
                        R.drawable.avantime,
                        R.drawable.sportspider,
                        R.drawable.r20,
                        R.drawable.r14,
                        R.drawable.r15,
                        R.drawable.logan,
                        R.drawable.koleos,
                        R.drawable.sandero_stepway,
                        R.drawable.fluence,
                        R.drawable.wind,
                        R.drawable.latitude,
                        R.drawable.duster
                };

                names = context.getResources().getStringArray(R.array.Renault);
                for (int i=0; i<names.length; i++){
                    ModeleImage tmp = new ModeleImage();
                    tmp.setResID(images[i]);
                    tmp.setName(names[i]);
                    modeles.add(tmp);
                }

                return modeles;

            case "Rover" :

                images = new int[]{
                        R.drawable.ro75,
                        R.drawable.ro200,
                        R.drawable.ro600,
                        R.drawable.ro400,
                        R.drawable.ro25,
                        R.drawable.ro45,
                        R.drawable.minimki,
                        R.drawable.ro800,
                        R.drawable.ro100,
                        R.drawable.coupe,
                        R.drawable.ro22003500,
                        R.drawable.ro2000350035portes,
                        R.drawable.streetwise,
                        R.drawable.cabriolet,
                        R.drawable.maestro,
                        R.drawable.montego,
                        R.drawable.cityrover,
                        R.drawable.a60cambridge
                };

                names = context.getResources().getStringArray(R.array.Rover);
                for (int i=0; i<names.length; i++){
                    ModeleImage tmp = new ModeleImage();
                    tmp.setResID(images[i]);
                    tmp.setName(names[i]);
                    modeles.add(tmp);
                }

                return modeles;

            case "Saab" :

                images = new int[]{
                        R.drawable.sa93,
                        R.drawable.sa95,
                        R.drawable.sa900,
                        R.drawable.sa90,
                        R.drawable.sa9000,
                        R.drawable.sa96,
                        R.drawable.sa97x,
                        R.drawable.sa95stationwagon,
                        R.drawable.sa99
                };

                names = context.getResources().getStringArray(R.array.Saab);
                for (int i=0; i<names.length; i++){
                    ModeleImage tmp = new ModeleImage();
                    tmp.setResID(images[i]);
                    tmp.setName(names[i]);
                    modeles.add(tmp);
                }

                return modeles;

            case "Seat" :

                images = new int[]{
                        R.drawable.ibiza,
                        R.drawable.leon,
                        R.drawable.cordoba,
                        R.drawable.toledo,
                        R.drawable.altea,
                        R.drawable.alhambra,
                        R.drawable.arosa,
                        R.drawable.terra,
                        R.drawable.inca,
                        R.drawable.marbella,
                        R.drawable.fura,
                        R.drawable.panda,
                        R.drawable.s124,
                        R.drawable.s127,
                        R.drawable.s128,
                        R.drawable.s131,
                        R.drawable.s132,
                        R.drawable.s133,
                        R.drawable.s600d,
                        R.drawable.s850,
                        R.drawable.malaga,
                        R.drawable.ritmo,
                        R.drawable.ronda,
                        R.drawable.exeo,
                        R.drawable.mii
                };

                names = context.getResources().getStringArray(R.array.Seat);
                for (int i=0; i<names.length; i++){
                    ModeleImage tmp = new ModeleImage();
                    tmp.setResID(images[i]);
                    tmp.setName(names[i]);
                    modeles.add(tmp);
                }

                return modeles;

            case "Skoda" :

                images = new int[]{
                        R.drawable.octavia,
                        R.drawable.fabia,
                        R.drawable.felicia,
                        R.drawable.superb,
                        R.drawable.roomster,
                        R.drawable.favorit,
                        R.drawable.oktavia,
                        R.drawable.sk100,
                        R.drawable.rapid,
                        R.drawable.sk105120,
                        R.drawable.sk110,
                        R.drawable.sk1000,
                        R.drawable.sk1100,
                        R.drawable.sk130,
                        R.drawable.yeti,
                        R.drawable.citigo
                };

                names = context.getResources().getStringArray(R.array.Skoda);
                for (int i=0; i<names.length; i++){
                    ModeleImage tmp = new ModeleImage();
                    tmp.setResID(images[i]);
                    tmp.setName(names[i]);
                    modeles.add(tmp);
                }

                return modeles;

            case "Smart" :

                images = new int[]{
                        R.drawable.fortwo,
                        R.drawable.citycoupe,
                        R.drawable.cabrio,
                        R.drawable.forfour,
                        R.drawable.roadster,
                        R.drawable.crossblade
                };

                names = context.getResources().getStringArray(R.array.Smart);
                for (int i=0; i<names.length; i++){
                    ModeleImage tmp = new ModeleImage();
                    tmp.setResID(images[i]);
                    tmp.setName(names[i]);
                    modeles.add(tmp);
                }

                return modeles;

            case "SSangyong" :

                images = new int[]{
                        R.drawable.rexton,
                        R.drawable.kyron,
                        R.drawable.actyon,
                        R.drawable.korando,
                        R.drawable.musso,
                        R.drawable.rodius
                };

                names = context.getResources().getStringArray(R.array.SSangyong);
                for (int i=0; i<names.length; i++){
                    ModeleImage tmp = new ModeleImage();
                    tmp.setResID(images[i]);
                    tmp.setName(names[i]);
                    modeles.add(tmp);
                }

                return modeles;

            case "Subaru" :

                images = new int[]{
                        R.drawable.impreza,
                        R.drawable.legacy,
                        R.drawable.forester,
                        R.drawable.justy,
                        R.drawable.outback,
                        R.drawable.vanilleautobus_autocar,
                        R.drawable.vivio,
                        R.drawable.tribeca,
                        R.drawable.leone,
                        R.drawable.rex,
                        R.drawable.svx,
                        R.drawable.mv,
                        R.drawable.xv,
                        R.drawable.brz
                };

                names = context.getResources().getStringArray(R.array.Subaru);
                for (int i=0; i<names.length; i++){
                    ModeleImage tmp = new ModeleImage();
                    tmp.setResID(images[i]);
                    tmp.setName(names[i]);
                    modeles.add(tmp);
                }

                return modeles;

            case "Suzuki" :

                images = new int[]{
                        R.drawable.vitara,
                        R.drawable.swift,
                        R.drawable.grandvitara,
                        R.drawable.samurai,
                        R.drawable.jimny,
                        R.drawable.sj413,
                        R.drawable.alto,
                        R.drawable.ignis,
                        R.drawable.sj410,
                        R.drawable.wagonr,
                        R.drawable.sx4,
                        R.drawable.baleno,
                        R.drawable.liana,
                        R.drawable.supercarryautobus,
                        R.drawable.lj80,
                        R.drawable.carrycamionnette,
                        R.drawable.x90,
                        R.drawable.cappucino,
                        R.drawable.splash,
                        R.drawable.kizashi,
                        R.drawable.mrwagon
                };

                names = context.getResources().getStringArray(R.array.Suzuki);
                for (int i=0; i<names.length; i++){
                    ModeleImage tmp = new ModeleImage();
                    tmp.setResID(images[i]);
                    tmp.setName(names[i]);
                    modeles.add(tmp);
                }

                return modeles;

            case "Toyota" :

                images = new int[]{
                        R.drawable.corolla,
                        R.drawable.yaris,
                        R.drawable.landcruiser,
                        R.drawable.avensis,
                        R.drawable.rav4,
                        R.drawable.hiluxpickup,
                        R.drawable.aygo,
                        R.drawable.carina,
                        R.drawable.celica,
                        R.drawable.auris,
                        R.drawable.picnic,
                        R.drawable.starlet,
                        R.drawable.hiace,
                        R.drawable.prius,
                        R.drawable.t4runner,
                        R.drawable.supra,
                        R.drawable.mr2,
                        R.drawable.previa,
                        R.drawable.camry,
                        R.drawable.dyna,
                        R.drawable.corona,
                        R.drawable.liteace,
                        R.drawable.paseo,
                        R.drawable.tercel,
                        R.drawable.cressida,
                        R.drawable.modellfautobus_autocar,
                        R.drawable.copain,
                        R.drawable.crown,
                        R.drawable.matrix,
                        R.drawable.iq,
                        R.drawable.verso,
                        R.drawable.gt86,
                        R.drawable.camrysolara,
                        R.drawable.versos
                };

                names = context.getResources().getStringArray(R.array.Toyota);
                for (int i=0; i<names.length; i++){
                    ModeleImage tmp = new ModeleImage();
                    tmp.setResID(images[i]);
                    tmp.setName(names[i]);
                    modeles.add(tmp);
                }

                return modeles;

            case "Volkswagen" :

                images = new int[]{
                        R.drawable.golf,
                        R.drawable.polo,
                        R.drawable.passat,
                        R.drawable.transporter,
                        R.drawable.touran,
                        R.drawable.sharan,
                        R.drawable.lupo,
                        R.drawable.caddy,
                        R.drawable.bora,
                        R.drawable.touareg,
                        R.drawable.multivan,
                        R.drawable.tiguan,
                        R.drawable.kaefer,
                        R.drawable.newbeetle,
                        R.drawable.fox,
                        R.drawable.scirocco,
                        R.drawable.jetta,
                        R.drawable.lt,
                        R.drawable.vento,
                        R.drawable.corrado,
                        R.drawable.crafter,
                        R.drawable.eos,
                        R.drawable.phaeton,
                        R.drawable.derby,
                        R.drawable.santana,
                        R.drawable.taro,
                        R.drawable.gol,
                        R.drawable.parati,
                        R.drawable.saveiro,
                        R.drawable.voyage,
                        R.drawable.spacefox,
                        R.drawable.amarok,
                        R.drawable.up
                };

                names = context.getResources().getStringArray(R.array.Volkswagen);
                for (int i=0; i<names.length; i++){
                    ModeleImage tmp = new ModeleImage();
                    tmp.setResID(images[i]);
                    tmp.setName(names[i]);
                    modeles.add(tmp);
                }

                return modeles;

            case "Volvo" :

                images = new int[]{
                        R.drawable.v40break,
                    R.drawable.v70,
                    R.drawable.s40,
                    R.drawable.s60,
                    R.drawable.v240,
                    R.drawable.s80,
                    R.drawable.v50,
                    R.drawable.xc90,
                    R.drawable.v850,
                    R.drawable.v940,
                    R.drawable.c30,
                    R.drawable.v740,
                    R.drawable.xc70,
                    R.drawable.c70,
                    R.drawable.s70,
                    R.drawable.v960,
                    R.drawable.v460l,
                    R.drawable.v140,
                    R.drawable.v440k,
                    R.drawable.v480e,
                    R.drawable.v340360,
                    R.drawable.v760,
                    R.drawable.v164,
                    R.drawable.v780,
                    R.drawable.s90,
                    R.drawable.v90break,
                    R.drawable.duett,
                    R.drawable.v260,
                    R.drawable.v66,
                    R.drawable.xc60,
                    R.drawable.v40,
                    R.drawable.v60
                };

                names = context.getResources().getStringArray(R.array.Volvo);
                for (int i=0; i<names.length; i++){
                    ModeleImage tmp = new ModeleImage();
                    tmp.setResID(images[i]);
                    tmp.setName(names[i]);
                    modeles.add(tmp);
                }

                return modeles;

            default:
                return modeles;
        }

    }

    public static ArrayList<ModeleImage> getMarqueData(Context c){

        ArrayList<ModeleImage> models = new ArrayList<ModeleImage>();

        int[] imageRes = new int[]{
                R.drawable.alfaromeo, R.drawable.audi, R.drawable.bmw,
                R.drawable.cadilac, R.drawable.chevrolet, R.drawable.chrysler,
                R.drawable.citroen, R.drawable.dacia, R.drawable.daewoo,
                R.drawable.daihatsu, R.drawable.dodge, R.drawable.ferrari,
                R.drawable.fiat, R.drawable.ford, R.drawable.honda,
                R.drawable.hyunda, R.drawable.isuzu, R.drawable.jaguar,
                R.drawable.jeep, R.drawable.kia, R.drawable.lamborghini,
                R.drawable.lancia, R.drawable.landrover, R.drawable.lexus,
                R.drawable.mazda, R.drawable.mercedesbenz, R.drawable.mgmarque,
                R.drawable.minimarque, R.drawable.mitsubishi, R.drawable.nissan,
                R.drawable.opel, R.drawable.peugeot, R.drawable.porsche,
                R.drawable.renault, R.drawable.rover, R.drawable.saab,
                R.drawable.seat, R.drawable.skoda, R.drawable.smart,
                R.drawable.ssangyong, R.drawable.subaru, R.drawable.suziki,
                R.drawable.toyota, R.drawable.volkswagen, R.drawable.volvo
        };

        List<String> marque = Arrays.asList(c.getResources().getStringArray(R.array.marques));

        for(int i = 0; i<imageRes.length; i++){
            ModeleImage mi = new ModeleImage();
            mi.setName(marque.get(i));
            mi.setResID(imageRes[i]);
            models.add(mi);
        }

        return models;
    }


    public static int getMarqueImgResByName(Context c,String marque){
        ArrayList<ModeleImage> modele = getMarqueData(c);

        int res = R.drawable.bmw;
        for(int i = 0; i<modele.size(); i++){
            if(modele.get(i).getName().equals(marque)){
                res = modele.get(i).getResID();
                break;
            }
        }
        return res;
    }

    public static int getModeleImgResByName(Context c,String marque, String modele){
        ArrayList<ModeleImage> model = getModelWithMarque(c, marque);

        int res = R.drawable.x1;
        for(int i = 0; i<model.size(); i++){
            if(model.get(i).getName().equals(modele)){
                res = model.get(i).getResID();
                break;
            }
        }
        return res;
    }
}
