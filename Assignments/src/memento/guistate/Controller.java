
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> undoList; // Memento history
    private List<IMemento> redoList; // Memento history

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.undoList = new ArrayList<>();
        this.redoList = new ArrayList<>();
    }



    public void setOption(int optionNumber, int choice) {
        saveToHistory();
        model.setOption(optionNumber, choice);
        redoList.clear();
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToHistory();
        model.setIsSelected(isSelected);
        redoList.clear();
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    // When the user hits Ctrl-Z, the current state is added to the redo list.
    // Then, a state is removed from the undo list and restored in the application.
    public void undo() {
        if (!undoList.isEmpty()) {
            System.out.println("Memento found in history");
            IMemento currentState = model.createMemento();
            redoList.add(currentState);
            IMemento previousState = undoList.remove(undoList.size() - 1);
            model.restoreState(previousState);
            gui.updateGui();
        }
    }

    // When the user hits Ctrl-Y, the current state is added to the undo list.
    // Then, a state is removed from the redo list and restored in the application.
    // The redo list should be cleared when the user makes a new change to the model.
    public void redo() {
        if (!redoList.isEmpty()) {
            System.out.println("Memento found in redo history");
            IMemento currentState = model.createMemento();
            undoList.add(currentState);
            IMemento nextState = redoList.remove(redoList.size() - 1);
            model.restoreState(nextState);
            gui.updateGui();
        }
    }

    private void saveToHistory() {
        IMemento currentState = model.createMemento();
        undoList.add(currentState);
    }

    public IMemento[] getUndoList() {
        return undoList.toArray(new IMemento[0]);
    }

    public IMemento[] getRedoList() {
        return redoList.toArray(new IMemento[0]);
    }

    public void restoreState(IMemento memento) {
        // Save current state to undo history
        saveToHistory();
        // Clear redo history
        redoList.clear();
        // Restore the model state
        model.restoreState(memento);
        // Update the GUI
        gui.updateGui();
    }

}
