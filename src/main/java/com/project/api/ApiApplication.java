package com.project.api;

import com.project.api.models.AppUser;
import com.project.api.models.Business;
import com.project.api.repositories.BusinessRepository;
import com.project.api.repositories.UserRepository;
// import com.vividsolutions.jts.geom.Coordinate;
// import com.vividsolutions.jts.geom.GeometryFactory;
// import com.vividsolutions.jts.geom.Point;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEndcoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	// test data
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BusinessRepository businessRepository;

	@Override
	public void run(String... arg0) throws Exception {

		String[][] users = { 
      {"jobstevens@gmail.com", "aaa", "Job", "Stevens", "https://ninjawiththeorangetshirt.files.wordpress.com/2010/11/jobbbs.jpg", "35.350204", "-119.104669", "false"},
			{"AZ@gmail.com", "password", "Amber", "Zaragoza", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "0.0", "0.0", "false"},
			{"tommychong@gmail.com", "aaa", "Tommy", "Chong", "https://cdn.inquisitr.com/wp-content/uploads/2016/05/Tommy.jpg", "35.354055", "-119.092246", "true"},
	    {"billgates@gmail.com", "aaa", "Bill", "Gates", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/19/Bill_Gates_June_2015.jpg/424px-Bill_Gates_June_2015.jpg", "35.355239", "-119.058780", "true"},
			{"markfuckerberg@gmail.com", "aaa", "Mark", "Fuckerberg", "https://i2.wp.com/zorbtour.com/wp-content/uploads/2017/07/img_6712.jpg?fit=371%2C213&ssl=1", "35.372052", "-119.138482", "true"},
			{"cheechmarin@gmail.com", "aaa", "Cheech", "Marin", "https://cdn.inquisitr.com/wp-content/uploads/2016/05/Tommy.jpg", "35.307785", "-119.104683", "true"},
			{"mbalshaw0@networkadvertising.org", "password", "Marlowe", "Balshaw", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.3564995", "-119.0798786", "true"},
      {"omoorman1@utexas.edu", "password", "Oswell", "Moorman", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.3436698", "-119.1137115", "true"},
      {"irowswell2@imgur.com", "password", "Iormina", "Rowswell", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.4216975", "-119.1068501", "true"},
      {"dstaggs3@irs.gov", "password", "Deina", "Staggs", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.3578865", "-119.0537921", "true"},
      {"methelstone4@quantcast.com", "password", "Myrna", "Ethelstone", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.3968368", "-119.0805683", "true"},
      {"tlandor5@nhs.uk", "password", "Tillie", "Landor", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.3065353", "-119.0246364", "true"},
      {"scoop6@cargocollective.com", "password", "Stesha", "Coop", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.3738113", "-119.0182399", "true"},
      {"cjouannisson7@csmonitor.com", "password", "Cristi", "Jouannisson", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.312873", "-119.053477", "true"},
      {"adisley8@purevolume.com", "password", "Allianora", "Disley", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.4259516", "-119.0802195", "true"},
      {"jfather9@twitpic.com", "password", "Jerome", "Father", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.3472899", "-118.9483844", "true"},
      {"rdomotora@zimbio.com", "password", "Rosabella", "Domotor", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.398528", "-119.163932", "true"},
      {"dparysownab@blogspot.com", "password", "Dom", "Parysowna", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.3890307", "-119.1318178", "true"},
      {"cladleyc@tinyurl.com", "password", "Carlye", "Ladley", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.3998244", "-119.1084147", "true"},
      {"fganforthed@si.edu", "password", "Florella", "Ganforthe", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.383082", "-119.160209", "true"},
      {"ctaffee@businessweek.com", "password", "Carleen", "Taffe", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.3916969", "-119.0905887", "true"},
      {"lbutlerf@histats.com", "password", "Leesa", "Butler", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.4091505", "-119.1116895", "true"},
      {"vbexleyg@hud.gov", "password", "Vladimir", "Bexley", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.3815445", "-119.1667292", "true"},
      {"bdurninh@google.de", "password", "Binnie", "Durnin", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.3997106", "-119.1174602", "true"},
      {"btullisi@engadget.com", "password", "Bertina", "Tullis", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.3937585", "-119.0728566", "true"},
      {"jgiamellij@digg.com", "password", "Janot", "Giamelli", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.3144986", "-119.0737097", "true"},
      {"snutteyk@netlog.com", "password", "Salomo", "Nuttey", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.4199316", "-119.0661411", "true"},
      {"gparradyel@mail.ru", "password", "Georgette", "Parradye", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.3837188", "-119.2092617", "true"},
      {"aazemarm@squidoo.com", "password", "Ardene", "Azemar", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.422458", "-119.0229319", "true"},
      {"nscayn@cornell.edu", "password", "Nertie", "Scay", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.3965867", "-119.1451291", "true"},
      {"gcoppo@google.com.hk", "password", "Gavin", "Copp", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.4144557", "-119.0680614", "true"},
      {"dgreetlandp@hp.com", "password", "Dallis", "Greetland", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.4098812", "-119.1339531", "true"},
      {"okiraq@auda.org.au", "password", "Oralla", "Kira", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.3821271", "-119.1475756", "true"},
      {"mbellinr@networkadvertising.org", "password", "Marjory", "Bellin", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.3916067", "-119.1185961", "true"},
      {"vcampkins@ask.com", "password", "Valentia", "Campkin", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.3881363", "-119.1458659", "true"},
      {"bpracyt@unesco.org", "password", "Byram", "Pracy", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.3893901", "-119.1467168", "true"},
      {"bobspersonal@gmail.com", "password123", "Bob", "Smith", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.413496", "-119.131626", "true"},
      {"tedspersonal@gmail.com", "password123", "Ted", "Smith", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.412366", "-119.102752", "true"},
      {"robertpersonal@gmail.com", "password123", "Robert", "Smith", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.398352", "-119.091078", "true"},
      {"chadspersonal@gmail.com", "password123", "Chad", "Smith", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.280669", "-119.055487", "true"},
      {"dinglespersonal@gmail.com", "password123", "Dingle", "Dooper", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.408949", "-119.020985", "true"},
      {"donglespersonal@gmail.com", "password123", "Dongle", "Dude", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.324338", "-119.029985", "true"},
      {"doopittyspersonal@gmail.com", "password123", "Doopitty", "DooDoo", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.311665", "-119.05628", "true"},
      {"rawspersonal@gmail.com", "password123", "Raw", "DiggityDog", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.339259", "-119.1142", "true"},
      {"supergreatpersonal@gmail.com", "password123", "Super", "Great", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.319116", "-119.075584", "true"},
      {"thebestpersonal@gmail.com", "password123", "Besty", "ComputerGuy", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.347947", "-119.002591", "true"},
      {"dankstankypersonal@gmail.com", "password123", "Danky", "Stanky", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.345891", "-119.04871", "true"},
      {"supremebudpersonal@gmail.com", "password123", "Sup", "Buddy", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.35363", "-119.06018", "true"},
      {"gotsdaweedpersonal@gmail.com", "password123", "Sirgots", "DaWeed", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.324691", "-119.004332", "true"},
      {"simplepersonal@gmail.com", "password123", "Simple", "Smith", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.325542", "-119.048229", "true"},
      {"bigchronicpersonal@gmail.com", "password123", "Big", "Chron", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.367414", "-118.994789", "true"},
      {"superjointzpersonal@gmail.com", "password123", "Super", "DuperJayz", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.375905", "-118.950844", "true"},
      {"skunkypersonal@gmail.com", "password123", "Smellz", "Skunky", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.36992", "-119.092607", "true"},
      {"decentpersonal@gmail.com", "password123", "Decent", "Smith", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.376986", "-119.128479", "true"},
      {"bombshizpersonal@gmail.com", "password123", "Bomb", "Shiz", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.32515", "-119.057806", "true"},
      {"snoopswarehousepersonal@gmail.com", "password123", "Snoop", "Dogg", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.324831", "-119.021766", "true"},
      {"wefixpersonal@gmail.com", "password123", "Well", "Fixem", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.331267", "-119.048258", "true"},
      {"pipebizpersonal@gmail.com", "password123", "Pipe", "Bizz", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.324518", "-119.021696", "true"},
      {"layinpipepersonal@gmail.com", "password123", "Pipe", "Layer", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.347087", "-119.0601", "true"},
      {"cleanpooperspersonal@gmail.com", "password123", "Squeeky", "Clean", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.368016", "-119.018607", "true"},
      {"fixespersonal@gmail.com", "password123", "Fixed", "Pipes", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.368359", "-118.994012", "true"},
      {"bestplumbspersonal@gmail.com", "password123", "Dabest", "Plum", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.331772", "-118.985801", "true"},
      {"ronjonpersonal@gmail.com", "password123", "Ron", "Jon", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.413162", "-119.020545", "true"},
      {"jackspersonal@gmail.com", "password123", "Jack", "Crap", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.396726", "-119.113053", "true"},
      {"bobspipespersonal@gmail.com", "password123", "Bob", "Pype", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.401218", "-119.075198", "true"},
      {"robsbetterpersonal@gmail.com", "password123", "Rob", "Better", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.331791", "-119.048029", "true"},
      {"bombtacospersonal@gmail.com", "password123", "Bomb", "Tacos", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.334277", "-119.075178", "true"},
      {"greekgeekpersonal@gmail.com", "password123", "Greeky", "Geeky", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.367622", "-119.021784", "true"},
      {"sushipersonal@gmail.com", "password123", "Sushi", "Wheels", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.367616", "-118.995997", "true"},
      {"gyrospersonal@gmail.com", "password123", "Gyro", "Foryu", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.36625", "-119.01629", "true"},
      {"superfoodpersonal@gmail.com", "password123", "Super", "Food", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.361771", "-119.026971", "true"},
      {"granolapersonal@gmail.com", "password123", "Granny", "Granola", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.355794", "-118.988983", "true"},
      {"bubbleteapersonal@gmail.com", "password123", "Bob", "Bubbletee", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.371347", "-118.989587", "true"},
      {"rockinravispersonal@gmail.com", "password123", "Ravi", "Ollie", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.38255", "-119.021325", "true"},
      {"tuckersspersonal@gmail.com", "password123", "Tucker", "Turkeyguy", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.358909", "-119.033836", "true"},
      {"leatherpersonal@gmail.com", "password123", "Boot", "Leather", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.358905", "-118.99066", "true"},
      {"lindaspersonal@gmail.com", "password123", "Linda", "Smith", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.364633", "-119.029374", "true"},
      {"stacyspersonal@gmail.com", "password123", "Stacy", "Smith", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.366471", "-119.015495", "true"},
      {"buymyhousespersonal@gmail.com", "password123", "Buyin", "Hoozes", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.358813", "-119.025339", "true"},
      {"ryansspersonal@gmail.com", "password123", "Really", "Real", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.357929", "-119.014051", "true"},
      {"rootinscootpersonal@gmail.com", "password123", "Rudy", "Scooty", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.356014", "-119.042856", "true"},
      {"robertsirrationalpersonal@gmail.com", "password123", "Robert", "Smithymangensen", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.366601", "-119.031739", "true"},
      {"ourhomespersonal@gmail.com", "password123", "Sell", "Best", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.367332", "-119.014129", "true"},
      {"realestatestorepersonal@gmail.com", "password123", "Real", "Estate", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.359664", "-119.031824", "true"},
      {"wesellhousespersonal@gmail.com", "password123", "Wesell", "House", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.340945", "-119.023336", "true"},
      {"thehouseplugpersonal@gmail.com", "password123", "Housie", "Pluggins", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.328371", "-119.053352", "true"},
      {"pcpestcontrolspersonal@gmail.com", "password123", "Politically", "Correct", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.402059", "-118.991663", "true"},
      {"roachessuckpersonal@gmail.com", "password123", "Roaches", "Suck", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.388847", "-119.051573", "true"},
      {"cleanhousepersonal@gmail.com", "password123", "Clean", "Yohouse", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.346351", "-119.026298", "true"},
      {"wekillpersonal@gmail.com", "password123", "Killer", "Termites", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.365869", "-118.925945", "true"},
      {"randysavagespersonal@gmail.com", "password123", "Macho", "Man", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.389377", "-119.048011", "true"},
      {"bobrosspersonal@gmail.com", "password123", "Bob", "Ross", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.333682", "-119.00526", "true"},
      {"miketysonpersonal@gmail.com", "password123", "Mike", "Tyson", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.347674", "-118.989401", "true"},
      {"hatedbyhornetspersonal@gmail.com", "password123", "Hornets", "Hateme", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.376448", "-119.023395", "true"},
      {"lynardspersonal@gmail.com", "password123", "Lynard", "Smith", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.408919", "-119.030532", "true"},
      {"skynnardspersonal@gmail.com", "password123", "Skynnard", "Smith", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.376971", "-118.95702", "true"},
      {"bobshvacpersonal@gmail.com", "password123", "Bobby", "Smith", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.348728", "-119.025005", "true"},
      {"tomshvacpersonal@gmail.com", "password123", "Tommy", "Smith", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.361135", "-118.969653", "true"},
      {"repairingpersonal@gmail.com", "password123", "Repair", "Shizz", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.395194", "-118.992959", "true"},
      {"notbobspersonal@gmail.com", "password123", "Notbob", "Smith", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.361132", "-118.959294", "true"},
      {"havocpersonal@gmail.com", "password123", "Havoc", "Smiddie", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.38965", "-119.002026", "true"},
      {"qualitypersonal@gmail.com", "password123", "Quality", "Hvac", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.333419", "-119.004612", "true"},
      {"midteirpersonal@gmail.com", "password123", "Middy", "Smith", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.347926", "-119.052516", "true"},
      {"saltyspersonal@gmail.com", "password123", "Salty", "Splat", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.393874", "-118.992311", "true"},
      {"staycoolpersonal@gmail.com", "password123", "Stayin", "Koolaf", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.383568", "-118.947302", "true"},
      {"kingspersonal@gmail.com", "password123", "Alec", "Shamrock", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.370093", "-118.926265", "true"},
      {"poolcleanerspersonal@gmail.com", "password123", "Pool", "Cleaner", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.404433", "-118.975791", "true"},
      {"wecleanspersonal@gmail.com", "password123", "We", "Cleanin", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.350047", "-119.025652", "true"},
      {"serenitypersonal@gmail.com", "password123", "Serenity", "Swims", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.360869", "-118.960589", "true"},
      {"justkeeppersonal@gmail.com", "password123", "Dory", "Thefish", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.39097", "-118.990044", "true"},
      {"sweetswimminspersonal@gmail.com", "password123", "Super", "Swimming", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.373008", "-118.947309", "true"},
      {"squeakyspersonal@gmail.com", "password123", "Squeaky", "Clean", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.393346", "-118.986482", "true"},
      {"sexyswimspersonal@gmail.com", "password123", "Pamela", "Anderson", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.357424", "-119.032777", "true"},
      {"topnotchpersonal@gmail.com", "password123", "Toppy", "Notchy", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.273955", "-119.056453", "true"},
      {"tedspersonal@gmail.com", "password123", "Teddy", "Poolguy", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.306741", "-118.995353", "true"},
      {"bobspoolspersonal@gmail.com", "password123", "Bobby", "Pooly", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.336443", "-119.008052", "true"},
      {"randyspersonal@gmail.com", "password123", "Randy", "God", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.394445", "-118.991887", "true"},
      {"cleanpuppersonal@gmail.com", "password123", "Puppy", "Cleaner", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.315428", "-119.007025", "true"},
      {"mandyspersonal@gmail.com", "password123", "Mandy", "Dandy", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.32411", "-119.054758", "true"},
      {"kittysforkpersonal@gmail.com", "password123", "Kitty", "Wook", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.331678", "-118.995345", "true"},
      {"groovypuppersonal@gmail.com", "password123", "Groove", "Puppers", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.322986", "-119.06506", "true"},
      {"kathysspersonal@gmail.com", "password123", "Kathy", "Bates", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.336721", "-118.996374", "true"},
      {"dogwalkerspersonal@gmail.com", "password123", "Dog", "Bountyhunter", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.308422", "-118.998443", "true"},
      {"kittyclawcutterspersonal@gmail.com", "password123", "Claw", "Kuttin", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.355768", "-119.069546", "true"},
      {"lizardspersonal@gmail.com", "password123", "Lilly", "Lizard", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.297216", "-119.104669", "true"},
      {"totalkatkarepersonal@gmail.com", "password123", "Catty", "Careperson", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.35577", "-118.977472", "true"},
      {"bushmowerpersonal@gmail.com", "password123", "Mowin", "Bush", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.401381", "-118.983284", "true"},
      {"jonspersonal@gmail.com", "password123", "Jon", "Lawn", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.381801", "-119.071919", "true"},
      {"josespersonal@gmail.com", "password123", "Jose", "Roberts", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.409246", "-119.062303", "true"},
      {"bushmanagerpersonal@gmail.com", "password123", "Bushy", "Manager", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.382345", "-118.996699", "true"},
      {"trimminbushpersonal@gmail.com", "password123", "Trimde", "Bushes", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.384036", "-119.023146", "true"},
      {"masterlawnpersonal@gmail.com", "password123", "Lawnie", "Masters", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.34091", "-119.018018", "true"},
      {"lawnandorderpersonal@gmail.com", "password123", "Lawn", "Order", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.385162", "-119.06505", "true"},
      {"gardenguyspersonal@gmail.com", "password123", "Gardenguy", "One", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.342312", "-119.023167", "true"},
      {"greatgreenerypersonal@gmail.com", "password123", "Greg", "Greenery", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.334461", "-118.999484", "true"},
      {"zodiackillerpersonal@gmail.com", "password123", "Ted", "Cruz", "https://vips.org/wp-content/uploads/2017/07/avatar-female.png", "35.399428", "-118.996685", "true"}
      
		};
      String[][] businesses = { {"Orange Computer Repair", "CA", "OrangePcRepair@gmail.com", "6615552365", "6615553248", "7900 Pegasus Dr.", "Bakersfield", "93301", "computer"},
                                {"Amber's Business", "CA", "AZbusiness@gmail.com", "6615552365", "6615553248", "8156 Orange Dr.", "Bakersfield", "93302", "computer"},
                                {"Chong Bongs", "CA", "chongbongs@gmail.com", "6615552365", "6615553248", "8156 Orange Dr.", "Bakersfield", "93302", "Cannabis"},
                                {"Microsoft Computer Repair", "CA", "microsoft@gmail.com", "6615552365", "6615553248", "4266 Mountain View Rd.", "Bakersfield", "93302", "computer"},
                                {"Fuckerbergs Ripoff Repair", "CA", "ripoff@gmail.com", "6615552365", "6615553248", "8156 Zucks Rd.", "Bakersfield", "93302", "computer"},
                                {"Mr. Niceguy", "CA", "herbaldelivery@gmail.com", "6615552365", "6615553248", "6513 Sky Dr.", "Bakersfield", "93302", "cannabis"},
																{"Kidwell Brothers Carpet Cleaning", "CA", "ekidwell@bak.rr.com", "6613975322", "6613975322", "304 Peregrine Ct", "Bakersfield", "93309", "carpetcleaning"},
																{"Sun Carpet & Upholstery Cleaning", "CA", "sun.carpet@yahoo.com", "6616993270", "6616993270", "10001 Camino Media", "Bakersfield", "93311", "carpetcleaning"},
																{"TUFF Carpet Cleaning", "CA", "contact@kerncleaningservices.com", "6613767767", "6613767767", "9402 Oak Hills Ave", "Bakersfield", "93312", "carpetcleaning"},
																{"Heaven's Best Carpet Cleaners", "CA", "heavensbestinbakersfield@yahoo.com", "6613272907", "6615874767", "4601 Perris Way", "Bakersfield", "93309", "carpetcleaning"},
																{"Clean Stride", "CA", "contact@cleanstride.com", "6612819245", "6612819245", "4031 Alken Street", "Bakersfield", "93308", "carpetcleaning"},
																{"Excellence Janitorial Services & Carpet Cleaning", "CA", "excellencedworthy@sbcglobal.net", "6618330934", "6617030678", "2005 Faith Ave", "Bakersfield", "93304", "carpetcleaning"},
																{"California Carpet Cleaning", "CA", "ca.carpetcleaning@att.net", "6617487837", "6617487837", "1430 Truxtun Ave", "Bakersfield", "93301", "carpetcleaning"},
																{"Bakersfield Chem-Dry", "CA", "contact@bakerfieldcd.com", "6613971475", "6613971475", "4600 District Blvd", "Bakersfield", "93313", "carpetcleaning"},
																{"City Carpet Cleaning", "CA", "gwebb7298@sbcglobal.net", "6613933155", "6613933155", "7009 Luke Ave", "Bakersfield", "93308", "carpetcleaning"},
																{"Mr. Mario's Carpet Cleaning", "CA", "contact@upholsterycleanersbakersfield.com", "6614773270", "6614773270", "5009 San Lucas Dr", "Bakersfield", "93307", "carpetcleaning"},
																{"Advanced Plumbing Service", "CA", "contact@advancedplumbingrepairspecialist.com", "6618340424", "6618340424", "4253 Renfro Rd", "Bakersfield", "93314", "plumber"},
																{"Amen Plumbing and Drain", "CA", "contact@amenplumbing.net", "6613489336", "6613489336", "3203 Aires Ct", "Bakersfield", "93312", "plumber"},
																{"Ron's Speedy Rooter & Plumbing Repair, Inc", "CA", "capaldiron@yahoo.com", "6618322100", "6618322100", "9530 Hageman Rd", "Bakersfield", "93312", "plumber"},
																{"Slater Plumbing & Mechanical", "CA", "info@slaterplumbing.com", "6615875999", "6615875999", "14213 Rosedale Hwy", "Bakersfield", "93314", "plumber"},
																{"Robo Plumbing", "CA", "support@roboplumbing.com", "6613236000", "6613236000", "3535 Bowman Ct", "Bakersfield", "93308", "plumber"},
																{"J. Woods Plumbing & Drain Cleaning", "CA", "contact@jwoodsplumbing.com", "6615774294", "6615774294", "9809 Balvanera Ave", "Bakersfield", "93312", "plumber"},
																{"Golden Quality Plumbing", "CA", "contact@goldenqualityplumbing.com", "6618292106", "6615470901", "14760 Greatest Pl", "Bakersfield", "93314", "plumber"},
																{"All Around Plumbing Sewer & Drain", "CA", "service@allaroundplumbing.org", "6618550221", "6618550221", "4407 Polo Sky Way", "Bakersfield", "93312", "plumber"},
																{"Frontier Plumbing", "CA", "customercare@frontier-plumbing.com", "6615896203", "6615896203", "6309 7 Seas Ave", "Bakersfield", "93308", "plumber"},
																{"Bakersfield Plumbing Company", "CA", "contact@bakersfieldplumbingco.com", "6613972093", "6613972093", "4400 Ashe Rd ", "Bakersfield", "93313", "plumber"},
																{"Quality Gardening & Landscape Service", "CA", "info@leivagardening.business.site", "6613199153", "6613199153", "5710 Norris Rd", "Bakersfield", "93308", "gardener"},
																{"Icos Gardening Landscape", "CA", "contact@icosgardeningandlandscape.com", "6613306269", "6613306269", "18624 Rosedale Hwy", "Bakersfield", "93314", "landscaper"},
																{"B & M Gardening Services", "CA", "billanderson1565@sbcglobal.net", "6613995594", "6613995594", "138 Ray St", "Bakersfield", "93308", "landscaper"},
																{"Penney Lawn Services", "CA", "pls@penneylawnservice.com", "6615874788", "6615874788", "4000 Allen Rd", "Bakersfield", "93314", "landscaper"},
																{"Edwing Julca Gardening Services", "CA", "contact@ejgardening.com", "6615654226", "6615654226", "5816 Sally Ave", "Bakersfield", "93308", "landscaper"},
																{"Andrade's Gardening Services", "CA", "info@andradelandscapingonline.com", "9094968677", "9094968677", "11803 Kenseth St", "Bakersfield", "93312", "landscaper"},
																{"Salazar Landscape Company", "CA", "servicedesk@salazarlandscape.com", "6615292100", "6615292100", "13061 Rosedale Hwy", "Bakersfield", "93314", "landscaper"},
																{"Magana Landscape Corporation", "CA", "contact@maganalandscape.com", "6614043558", "6614043558", "10413 Cave Avenue", "Bakersfield", "93312", "landscaper"},
																{"Century Landscape", "CA", "contact@centurylandscape.com", "6615899516", "6615899516", "12951 Lynn Christi Ave", "Bakersfield", "93314", "landscaper"},
																{"Bolles Nursery Landscape", "CA", "contact@bollesnursery.com", "6615878104", "6615878104", "3255 Allen Rd", "Bakersfield", "93314", "landscaper"},
																{"Bob’s Computer Repair", "CA", "bobscomputer@gmail.com", "6615452558", "6615556452", "3500 Mountain View Dr.", "Bakersfield", "93309", "computer"},
																{"Ted's Computer Repair", "CA", "tedscomputer@gmail.com", "6615443331", "6615443332", "4500 Mountain View Ave.", "Bakersfield", "93311", "computer"},
																{"Robert’s Computer Repair", "CA", "robertscomputer@gmail.com", "6615443333", "6615443334", "5600 Dinglehop Ave.", "Bakersfield", "93312", "computer"},
																{"Chad’s Computer Repair", "CA", "chadscomputer@gmail.com", "6615443335", "6615443336", "5700 SuperFruit St.", "Bakersfield", "93309", "computer"},
																{"Dingles’s Computer Repair", "CA", "dinglescomputer@gmail.com", "6615443337", "6615443338", "8899 Supreme Dr.", "Bakersfield", "93308", "computer"},
																{"Dongles’s Computer Repair", "CA", "donglescomputer@gmail.com", "6615443339", "6615443340", "9000 Mountain State Dr.", "Bakersfield", "93304", "computer"},
																{"Doopitty’s Computer Repair", "CA", "doopittyscomputer@gmail.com", "6615443341", "6615443342", "3500 Mountain View Dr.", "Bakersfield", "93301", "computer"},
																{"RawDawg Computer Repair", "CA", "rawdawgscomputer@gmail.com", "6615443343", "6615443344", "9999 Reeeee Dr.", "Bakersfield", "93313", "computer"},
																{"Super Great Computer Repair", "CA", "supergreatcomputer@gmail.com", "6615443343", "6615443344", "9009 Apples Ave.", "Bakersfield", "93308", "computer"},
																{"The Best Computer Repair", "CA", "thebestcomputercomputer@gmail.com", "6615443345", "6615443346", "8080 Low Dr.", "Bakersfield", "93307", "computer"},
																{"DankyStanky Weed Store", "CA", "dankystanky@gmail.com", "6615452558", "6615556452", "4000 Stoner St.", "Bakersfield", "93314", "cannabis"},
																{"Supreme Bud ", "CA", "supremebud@gmail.com", "6615452558", "6615556452", "4200 Sky High Dr.", "Bakersfield", "93312", "cannabis"},
																{"We Gots The Weed", "CA", "gotstheweed@gmail.com", "6615452558", "6615556452", "3690 Mountain Ave.", "Bakersfield", "93312", "cannabis"},
																{"Simple Dispensary", "CA", "dispensary@gmail.com", "6615452558", "6615556452", "2000 Mountain Dew Dr.", "Bakersfield", "93314", "cannabis"},
																{"Big Chronic ", "CA", "bigchronic@gmail.com", "6615452558", "6615556452", "3000 Big Chronic St.", "Bakersfield", "93308", "cannabis"},
																{"Super Jointz", "CA", "superjointz@gmail.com", "6615452558", "6615556452", "3555 Big Joints Dr.", "Bakersfield", "93312", "cannabis"},
																{"Smells Like Skunk", "CA", "superskunky@gmail.com", "6615452558", "6615556452", "6000 Skunky St.", "Bakersfield", "93314", "cannabis"},
																{"Decent Weed Store", "CA", "decentweed@gmail.com", "6615452558", "6615556452", "8000 Bad Weed Dr.", "Bakersfield", "93312", "cannabis"},
																{"The Bomb Shiz", "CA", "bombshiz@gmail.com", "6615452558", "6615556452", "0369 She Fine St.", "Bakersfield", "93308", "cannabis"},
																{"Snoops Warehouse ", "CA", "snoopdiggitydog@gmail.com", "6615452558", "6615556452", "1000 Gin and Juice Dr.", "Bakersfield", "93313", "cannabis"},
																{"We Fix Toilets", "CA", "fixingtoilets@gmail.com", "6615452558", "6615556452", "9000 Fix It Dr.", "Bakersfield", "93308", "plumber"},
																{"Pipes Are Our Biz", "CA", "pipes@gmail.com", "6615452558", "6615556452", "5600 Layin Pipes Ave.", "Bakersfield", "93314", "plumber"},
																{"Layin Pipes ", "CA", "layindown@gmail.com", "6615452558", "6615556452", " 235 Pipe St.", "Bakersfield", "93308", "plumber"},
																{"CleanerShitters ", "CA", "cleaner@gmail.com", "6615452558", "6615556452", "9902 Cleaner View Ave.", "Bakersfield", "93314", "plumber"},
																{"Fixed Pipes", "CA", "fixedpipes@gmail.com", "6615452558", "6615556452", "3500 Mountain View St.", "Bakersfield", "93308", "plumber"},
																{"Best Plumbers ", "CA", "thebestplumbers@gmail.com", "6615452558", "6615556452", "4500 Stupid Street Dr.", "Bakersfield", "93312", "plumber"},
																{"Ron Jon's Plumbing Service", "CA", "ronjonplumbing@gmail.com", "6615452558", "6615556452", "5600 Ron Jon Dr.", "Bakersfield", "93314", "plumber"},
																{"Jacks Crap Cleaners", "CA", "jackscrap.com", "6615452558", "6615556452", "5400 Jackin Crap Ave.", "Bakersfield", "93312", "plumber"},
																{"Bob and His Pipes", "CA", "bobandhispipes@gmail.com", "6615452558", "6615556452", "9909 Cleaner View St.", "Bakersfield", "93314", "plumber"},
																{"Rob's Better Pipes", "CA", "betterpipes@gmail.com", "6615452558", "6615556452", "9087 Mountain View Ave.", "Bakersfield", "93314", "plumber"},
																{"Bomb Ass Tacos", "CA", "bombasstacos@gmail.com", "6615452558", "6615556452", "6700 Tacos Dr.", "Bakersfield", "93309", "food"},
																{"Greek Geek Food Trucks", "CA", "greekfood@gmail.com", "6615452558", "6615556452", "909 Greek St.", "Bakersfield", "93311", "food"},
																{"Sushi On Wheels", "CA", "sushionwheels@gmail.com", "6615452558", "6615556452", "350 Sushi St.", "Bakersfield", "93312", "food"},
																{"Gyros For You", "CA", "gyros@gmail.com", "6615452558", "6615556452", "656 Run Away Ave.", "Bakersfield", "93309", "food"},
																{"Super Food Super Truck", "CA", "supertruckfood@gmail.com", "6615452558", "6615556452", "807 Super Food Ave.", "Bakersfield", "93308", "food"},
																{"Granola Kart", "CA", "granolakart@gmail.com", "6615452558", "6615556452", "350 Granola Dr.", "Bakersfield", "93304", "food"},
																{"Bubble Tea For Me", "CA", "bubbstea4me@gmail.com", "6615452558", "6615556452", "390 Bubble View St.", "Bakersfield", "93301", "food"},
																{"Rockin Rapid Raviolli ", "CA", "raviolli@gmail.com", "6615452558", "6615556452", "200 Really Good View Dr.", "Bakersfield", "93313", "food"},
																{"Tuckers Turkey Sammies", "CA", "ttstruck@gmail.com", "6615452558", "6615556452", "906 Sammie Ave.", "Bakersfield", "93308", "food"},
																{"We Serve BootLeather", "CA", "bootleather@gmail.com", "6615452558", "6615556452", "5406 Boot Leather St.", "Bakersfield", "93307", "food"},
																{"Linda's Home Sellin", "CA", "reallylinda@gmail.com", "6615452558", "6615556452", "333 Sellin View Dr.", "Bakersfield", "93314", "realestate"},
																{"Stacy's Better Home Sellin", "CA", "stacybetterhome@gmail.com", "6615452558", "6615556452", "909 Home St.", "Bakersfield", "93312", "realestate"},
																{"Buy My Houses Plz", "CA", "buyhousesplease@gmail.com", "6615452558", "6615556452", "404 Not Found Ave.", "Bakersfield", "93312", "realestate"},
																{"Ryans Really Real Real Estate", "CA", "ryan@gmail.com", "6615452558", "6615556452", "9009 Real Estate View Dr.", "Bakersfield", "93314", "realestate"},
																{"Rootin Scootin Real Estate", "CA", "rootinscootin@gmail.com", "6615452558", "6615556452", "976 The Bluffs Ave.", "Bakersfield", "93308", "realestate"},
																{"Robert's Irrational Real Estate", "CA", "irrational@gmail.com", "6615452558", "6615556452", "396 Dont Drive Here Ave.", "Bakersfield", "93312", "realestate"},
																{"Our Homes Sell Best", "CA", "sellinthebest@gmail.com", "6615452558", "6615556452", "300 My House Ave.", "Bakersfield", "93314", "realestate"},
																{"Real Estate Store", "CA", "storeofrealestate@gmail.com", "6615452558", "6615556452", "3456 Orange View Dr.", "Bakersfield", "93312", "realestate"},
																{"We Sell Houses", "CA", "housesforsale@gmail.com", "6615452558", "6615556452", "322 Apple View Dr.", "Bakersfield", "93308", "realestate"},
																{"The House Plug", "CA", "plugginhouses@gmail.com", "6615452558", "6615556452", "350 Mountain St.", "Bakersfield", "93313", "realestate"},
																{"Politically Correct Pest Control", "CA", "pcpestkillers@gmail.com", "6615452558", "6615556452", "999 Street Look St.", "Bakersfield", "93308", "pest"},
																{"Roaches Suck ", "CA", "roachesblow@gmail.com", "6615452558", "6615556452", "8076 Stonk Stoop Ave.", "Bakersfield", "93314", "pest"},
																{"Clean Yo House Pest Control", "CA", "housepest@gmail.com", "6615452558", "6615556452", "3421 Clean Pest Dr.", "Bakersfield", "93308", "pest"},
																{"We Kill Termites", "CA", "termitekillers@gmail.com", "6615452558", "6615556452", "3800 Killer Kill St.", "Bakersfield", "93314", "pest"},
																{"Randy Savage Roach Destruction", "CA", "roachdestruction@gmail.com", "6615452558", "6615556452", "8076 Roach Savage Ave.", "Bakersfield", "93308", "pest"},
																{"Bob Ross Pest Control", "CA", "pestcontrol@gmail.com", "6615452558", "6615556452", "7650 Painting Ross Dr.", "Bakersfield", "93312", "pest"},
																{"Mike Tyson PC", "CA", "therealmiketyson@gmail.com", "6615452558", "6615556452", "7607 Tiger Eye View St.", "Bakersfield", "93314", "pest"},
																{"Hornets Hate Us Pest Control", "CA", "beekillers405@gmail.com", "6615452558", "6615556452", "9876 Hate View Ave.", "Bakersfield", "93312", "pest"},
																{"Lynards Pest Control", "CA", "betterthanskynnard@gmail.com", "6615452558", "6615556452", "8876 Mountain Crunch Dr.", "Bakersfield", "93314", "pest"},
																{"Skynnards Pest Control", "CA", "betterthanlynard@gmail.com", "6615452558", "6615556452", "7650 Mountain Balls St.", "Bakersfield", "93314", "pest"},
																{"Bob’s HVAC", "CA", "bobs@gmail.com", "6615452558", "6615556452", "2134 Grass Cheese Dr.", "Bakersfield", "93309", "hvac"},
																{"Tom's HVAC", "CA", "toms@gmail.com", "6615452558", "6615556452", "0098 Tree Potatoes St.", "Bakersfield", "93311", "hvac"},
																{"Repairing AC Company", "CA", "acrepair@gmail.com", "6615452558", "6615556452", "9908 Raunchy Vape Ave.", "Bakersfield", "93312", "hvac"},
																{"Totally Not Bob's HVAC", "CA", "notbobs@gmail.com", "6615452558", "6615556452", "3456 Slippery Coffee Dr.", "Bakersfield", "93309", "hvac"},
																{"HAVOC HVAC", "CA", "havoc@gmail.com", "6615452558", "6615556452", "6634 Computer Mouse St.", "Bakersfield", "93308", "hvac"},
																{"Quality HVAC Repair", "CA", "qualityhvac@gmail.com", "6615452558", "6615556452", "3321 Cups Notebook Ave.", "Bakersfield", "93304", "hvac"},
																{"MidTeir HVAC Repair", "CA", "midteirhvac@gmail.com", "6615452558", "6615556452", "3009 House Towels Dr.", "Bakersfield", "93301", "hvac"},
																{"Salty Splatoon HVAC", "CA", "salty@gmail.com", "6615452558", "6615556452", "3670 Solar Cord St.", "Bakersfield", "93313", "hvac"},
																{"Stay Cool HVAC", "CA", "coolkidshvac@gmail.com", "6615452558", "6615556452", "3402 Old Pad Ave.", "Bakersfield", "93308", "hvac"},
																{"King's HVAC Repair", "CA", "thekings@gmail.com", "6615452558", "6615556452", "9905 Alec Cup Dr.", "Bakersfield", "93307", "hvac"},
																{"The Pool Cleaners", "CA", "poolcleaners@gmail.com", "6615452558", "6615556452", "4200 Mary Grapes Dr.", "Bakersfield", "93314", "pool"},
																{"We Clean Yo Pool Fool", "CA", "cleanyopool@gmail.com", "6615452558", "6615556452", "9907 Sweaty Oranges St.", "Bakersfield", "93312", "pool"},
																{"Serenity Swims", "CA", "serenity@gmail.com", "6615452558", "6615556452", "9098 Mountain Coffee Ave.", "Bakersfield", "93312", "pool"},
																{"Just Keep Swimming Pool Cleaners", "CA", "swimmingpool@gmail.com", "6615452558", "6615556452", "9987 No Lights Dr.", "Bakersfield", "93314", "pool"},
																{"Sweet Swimming Pool Cleaners", "CA", "sweetswimming@gmail.com", "6615452558", "6615556452", "3954 Mountain Mary St.", "Bakersfield", "93308", "pool"},
																{"Squeaky Clean Swimming", "CA", "squeakyclean@gmail.com", "6615452558", "6615556452", "7765 BlowUpThe Sun Ave.", "Bakersfield", "93312", "pool"},
																{"Super Sexy Swimming", "CA", "sexyswimming@gmail.com", "6615452558", "6615556452", "4450 Moon Dr.", "Bakersfield", "93314", "pool"},
																{"Top notch Pool Cleaning", "CA", "topnotch@gmail.com", "6615452558", "6615556452", "3999 Running Venus St.", "Bakersfield", "93312", "pool"},
																{"Ted's Pool Cleaners", "CA", "tedspoolcleaners@gmail.com", "6615452558", "6615556452", "3430 Seas Booty Ave.", "Bakersfield", "93308", "pool"},
																{"Bob’s Pool Cleaners", "CA", "bobspoolcleaners@gmail.com", "6615452558", "6615556452", "9908 Random Rubbish Dr.", "Bakersfield", "93313", "pool"},
																{"Randy Dog Walker", "CA", "randydogwalker@gmail.com", "6615452558", "6615556452", "3445 Sight Dr.", "Bakersfield", "93308", "animal"},
																{"Clean Up Yo Pup ", "CA", "cleanuppup@gmail.com", "6615452558", "6615556452", "9999 Saying Ave.", "Bakersfield", "93314", "animal"},
																{"Mandy's Mobile Vet Clinic", "CA", "manysmobile@gmail.com", "6615452558", "6615556452", "3222 Sucks St.", "Bakersfield", "93308", "animal"},
																{"Ketamine for Kitties ", "CA", "kittiensfork@gmail.com", "6615452558", "6615556452", "8867 Dirty View Dr.", "Bakersfield", "93314", "animal"},
																{"Groovy Dog Grooming", "CA", "groovygrooming@gmail.com", "6615452558", "6615556452", "7654 Sarah Sally Ave.", "Bakersfield", "93308", "animal"},
																{"Kathy's Kitty Groomin", "CA", "kittygrooming@gmail.com", "6615452558", "6615556452", "9906 Screaming Serenity St.", "Bakersfield", "93312", "animal"},
																{"The Dog Walkers", "CA", "walkersofdogs@gmail.com", "6615452558", "6615556452", "2234 Tesla Car Dr.", "Bakersfield", "93314", "animal"},
																{"Kitty Claw Cutters", "CA", "theclawcutters@gmail.com", "6615452558", "6615556452", "3509 Super Sayain Ave.", "Bakersfield", "93312", "animal"},
																{"Lizards Pets Services", "CA", "lizardsarepets@gmail.com", "6615452558", "6615556452", "6633 Goku St.", "Bakersfield", "93314", "animal"},
																{"Total Cat Care", "CA", "totalcatcare@gmail.com", "6615452558", "6615556452", "1244 Vegeta Dr.", "Bakersfield", "93314", "animal"},
																{"We Mow The Bush", "CA", "mowingbush@gmail.com", "6615452558", "6615556452", "35 Skyscraper Lean Dr.", "Bakersfield", "93309", "landscaper"},
																{"Jon's Lawn Care", "CA", "jonslawncare@gmail.com", "6615452558", "6615556452", "3245 Business Charger Ave.", "Bakersfield", "93311", "landscaper"},
																{"Jose Lawn Service", "CA", "jose@gmail.com", "6615452558", "6615556452", "3476 Credit Card Tower St.", "Bakersfield", "93312", "landscaper"},
																{"The Bush Manager", "CA", "bushmanager@gmail.com", "6615452558", "6615556452", "9906 Walmart Glass Dr.", "Bakersfield", "93309", "landscaper"},
																{"We Trim Stuff", "CA", "trimmingbushes@gmail.com", "6615452558", "6615556452", "5477 Dollar Store Yolo Ave.", "Bakersfield", "93308", "landscaper"},
																{"Masterful LawnScape", "CA", "masterful@gmail.com", "6615452558", "6615556452", "7760 Yolo Drive St.", "Bakersfield", "93304", "landscaper"},
																{"Lawn and Order", "CA", "lawnandorder@gmail.com", "6615452558", "6615556452", "8900 Poopin Street Dr.", "Bakersfield", "93301", "landscaper"},
																{"The Garden Guys", "CA", "guysgarden@gmail.com", "6615452558", "6615556452", "6776 Straight Dying Ave.", "Bakersfield", "93313", "landscaper"},
																{"Great Greenery Lawn Care", "CA", "supergreenery@gmail.com", "6615452558", "6615556452", "2234 Scoot Yelling St.", "Bakersfield", "93308", "landscaper"},
																{"The Zodiac Killer Lawn Care", "CA", "nottedcruz@gmail.com", "6615452558", "6615556452", "4056 Blue Cheese Screaming Dr.", "Bakersfield", "93307", "landscaper"}

		};

		createUsersFromArray(users, businesses);

	}

	public void createUsersFromArray(String[][] users, String[][] businesses){
		for(int i = 0; i < users.length; i++){
			createUsersAndBusinesses(users[i], businesses[i]);
		}
	}

	public void createUsersAndBusinesses(String[] user, String[] businessInfo) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		AppUser newUser = new AppUser();
		newUser.setUsername(user[0]);
		newUser.setPassword(passwordEncoder.encode(user[1]));
		newUser.setFirstName(user[2]);
		newUser.setLastName(user[3]);
		newUser.setAvatarLink(user[4]);

		// Point point = new GeometryFactory().createPoint(new Coordinate(0.0, 0.0));
		// newUser.setLocation(point);
		newUser.setLatitude(Double.valueOf(user[5]));
		newUser.setLongitude(Double.valueOf(user[6]));
		newUser.setIsOnline(Boolean.parseBoolean(user[7]));

		userRepository.save(newUser);

		if(businessInfo != null){
			Business business = new Business();
			business.setName(businessInfo[0]);
			business.setState(businessInfo[1]);
			business.setOwner(newUser);
			business.setEmail(businessInfo[2]);
			business.setPrimaryPhone(businessInfo[3]);
			business.setAltPhone(businessInfo[4]);
			business.setStreet(businessInfo[5]);
			business.setCity(businessInfo[6]);
			business.setZip(businessInfo[7]);
			business.setIndustry(businessInfo[8]);
			businessRepository.save(business);

		}



	}

}
