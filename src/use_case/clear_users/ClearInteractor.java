package use_case.clear_users;

// TODO Complete me

import java.util.Set;

public class ClearInteractor implements ClearInputBoundary {

    final ClearUserDataAccessInterface clearDataAccessObject;

    final ClearOutputBoundary outputPresenter;

    public ClearInteractor(ClearUserDataAccessInterface clearDataAccessObject, ClearOutputBoundary outputPresenter) {
        this.clearDataAccessObject = clearDataAccessObject;
        this.outputPresenter = outputPresenter;
    }

    @Override
    public void execute() {
        Set<String> deletedUsers = clearDataAccessObject.getAll();
        clearDataAccessObject.clear();

        // Passes output data into presenter
        ClearOutputData clearOutputData = new ClearOutputData(deletedUsers);
        outputPresenter.prepareSuccessView(clearOutputData);
    }
}
