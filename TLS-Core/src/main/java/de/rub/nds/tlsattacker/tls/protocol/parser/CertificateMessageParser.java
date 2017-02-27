/**
 * TLS-Attacker - A Modular Penetration Testing Framework for TLS
 *
 * Copyright 2014-2016 Ruhr University Bochum / Hackmanit GmbH
 *
 * Licensed under Apache License 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package de.rub.nds.tlsattacker.tls.protocol.parser;

import de.rub.nds.tlsattacker.tls.constants.HandshakeByteLength;
import de.rub.nds.tlsattacker.tls.constants.HandshakeMessageType;
import de.rub.nds.tlsattacker.tls.protocol.message.CertificateMessage;

/**
 *
 * @author Robert Merget - robert.merget@rub.de
 */
public class CertificateMessageParser extends HandshakeMessageParser<CertificateMessage> {

    public CertificateMessageParser(int startposition, byte[] array) {
        super(startposition, array, HandshakeMessageType.CERTIFICATE);
    }

    @Override
    public CertificateMessage parse() {
        CertificateMessage message = new CertificateMessage();
        parseType(message);
        parseLength(message);
        message.setCertificatesLength(parseIntField(HandshakeByteLength.CERTIFICATES_LENGTH));
        message.setX509CertificateBytes(parseByteArrayField(message.getCertificatesLength().getValue()));
        message.setCompleteResultingMessage(getAlreadyParsed());
        return message;
    }

}