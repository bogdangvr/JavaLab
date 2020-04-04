# Documentatie proiect:
# Aplicatie programari policlinica

- Classes:

    - Pacient: nume, varsta, id, dataConsultatie, dataAnalize, tratat, informatiiSuficiente (generat random), cost tratament;
Address: region, city,street, streetnumber;
Artist: name, description Contact: email, phone (of the account);
Event: name, category, type, location, date, status, details, artist;
In utils package:
Category: MUSIC, SPORT, ENTERTAINMENT, CULTURAL;
EventType: CONCERT, OPERA, MOVIE, FESTIVAL;
Status: CLOSED, INCOMING, CURRENT;
Location: name, address, details;
Ticket: account, event, price;
User: name, surname, age, address, contact;
Interactions:

AccountService: findbyId, getall, put, putall;
AddressService: findbyId, getall, put, putall;
ArtistService: findbyId, getall, put, putall;
ContactService: findbyId, getall, put, putall;
EventService: findbyId, getall, put, puall, getByArtist, getByType, getByCategory, getByStatus, getByLocation;
LocationService: findbyId, getall, put, putall;
TicketService: findbyId, getall, put, putall, getByEvent, getByAccount;
UserService: findbyId, getall, put, putall;
ModelsService: CreateEntities;
