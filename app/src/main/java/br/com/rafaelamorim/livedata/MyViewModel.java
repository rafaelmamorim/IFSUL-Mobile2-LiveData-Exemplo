package br.com.rafaelamorim.livedata;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    // Criar uma MutableLiveData para manipular os dados
    private final MutableLiveData<String> text = new MutableLiveData<>();

    // Método para acessar a LiveData (imutável fora do ViewModel)
    public LiveData<String> getText() {
        return text;
    }

    // Método para atualizar os dados da LiveData
    public void updateText(String newText) {
        text.setValue(newText);
    }
}
