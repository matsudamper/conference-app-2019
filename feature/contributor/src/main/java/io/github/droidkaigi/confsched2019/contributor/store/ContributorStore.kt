package io.github.droidkaigi.confsched2019.contributor.store

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import io.github.droidkaigi.confsched2019.action.Action
import io.github.droidkaigi.confsched2019.dispatcher.Dispatcher
import io.github.droidkaigi.confsched2019.ext.android.toLiveData
import io.github.droidkaigi.confsched2019.model.ContributorContents
import io.github.droidkaigi.confsched2019.model.LoadingState
import kotlinx.coroutines.channels.map
import javax.inject.Inject

class ContributorStore @Inject constructor(
    dispatcher: Dispatcher
) : ViewModel() {
    val loadingState: LiveData<LoadingState> = dispatcher
        .subscribe<Action.ContributorLoadingStateChanged>()
        .map { it.loadingState }
        .toLiveData(LoadingState.LOADING)

    val contributors: LiveData<ContributorContents> = dispatcher
        .subscribe<Action.ContributorLoaded>()
        .map { it.contributors }
        .toLiveData(ContributorContents.EMTPY)
}
