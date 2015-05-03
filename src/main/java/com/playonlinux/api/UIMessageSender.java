package com.playonlinux.api;

import com.playonlinux.utils.CancelException;
import com.playonlinux.utils.messages.Message;
import com.playonlinux.utils.messages.SynchroneousMessage;

public interface UIMessageSender <ReturnType> {
    ReturnType synchroneousSendAndGetResult(SynchroneousMessage<ReturnType> message) throws InterruptedException, CancelException;

    void synchroneousSend(Message message);

    void asynchroneousSend(Message message);
}