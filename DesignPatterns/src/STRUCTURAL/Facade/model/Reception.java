package STRUCTURAL.Facade.model;

public class Reception {
    LuggageService luggageService=new LuggageService();
    RestaurantService restaurantService=new RestaurantService();
    RoomService roomService=new RoomService();

    public void checkIn(){
        roomService.cleanRoom();
        luggageService.pickupLuggage();
        luggageService.dropLuggage();
    }

    public void checkOut(){
        roomService.cleanRoom();
        luggageService.pickupLuggage();
        luggageService.dropLuggage();
    }

    public void wantFood(){
        restaurantService.serveFood();
    }
}
