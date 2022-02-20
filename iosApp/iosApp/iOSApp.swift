import SwiftUI

@main
struct iOSApp: App {



 private let networkModule: NetworkModule

    @ObservedObject var viewModel: UsersViewModel

    init(
        networkModule: NetworkModule,
    ) {
        self.networkModule = networkModule

        self.viewModel = UsersViewModel(
            service: searchRecipesModule.searchRecipes,
        )
        // dismiss keyboard when drag starts
        UIScrollView.appearance().keyboardDismissMode = .onDrag
    }
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}